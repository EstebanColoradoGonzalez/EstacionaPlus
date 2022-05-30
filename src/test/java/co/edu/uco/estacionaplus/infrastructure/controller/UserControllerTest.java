package co.edu.uco.estacionaplus.infrastructure.controller;

import co.edu.uco.estacionaplus.application.dto.UserDTO;
import co.edu.uco.estacionaplus.domain.port.UserRepository;
import co.edu.uco.estacionaplus.infrastructure.ApplicationMock;
import co.edu.uco.estacionaplus.infrastructure.controller.response.Response;
import co.edu.uco.estacionaplus.infrastructure.testdatabuilder.LoginDTOTestDataBuilder;
import co.edu.uco.estacionaplus.infrastructure.testdatabuilder.UserDTOTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.core.Is.is;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = ApplicationMock.class)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserControllerTest
{
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("It must create a user successful and fail to create the same")
    void createDuplicateTest() throws Exception
    {
        var dto = new UserDTOTestDataBuilder().build();

        create(dto);

        String token = obtenerToken();

        mocMvc.perform(MockMvcRequestBuilders.post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization",token)
                        .content(objectMapper.writeValueAsString(dto))
                )
                .andExpect(status().isInternalServerError());
    }

    @Test
    @DisplayName("It must create a user successful and validate if it is saved")
    void createTest() throws Exception
    {
        var dto = new UserDTOTestDataBuilder().build();

        create(dto);
    }

    @Test
    @DisplayName("it must get all users saved")
    void getUsersTest() throws Exception {

        var dto = new UserDTOTestDataBuilder().build();

        create(dto);

        String token = obtenerToken();

        mocMvc.perform(get("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization",token))
                .andExpect(status().isAccepted());
    }

    private void create(UserDTO dto) throws Exception
    {
        var result = mocMvc.perform(MockMvcRequestBuilders.post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto))
                ).andExpect(status().isAccepted())
                .andReturn();

        //assert
        var jsonResult = result.getResponse().getContentAsString();
        var respuesta = objectMapper.readValue(jsonResult, Response.class);

        var message = respuesta.getMessages().get(0);
        Assertions.assertEquals("the user was created successful", message);
    }

    private String obtenerToken() throws Exception
    {
        var login = new LoginDTOTestDataBuilder().build();
        var resultLogin = mocMvc.perform(MockMvcRequestBuilders.post("/api/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(login))
                )
                .andExpect(status().isOk())
                .andReturn();

        return (String) objectMapper.readValue(resultLogin.getResponse().getContentAsString(), Response.class).getData().get(0);
    }
}
