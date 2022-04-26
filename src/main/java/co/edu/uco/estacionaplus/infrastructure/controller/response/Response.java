package co.edu.uco.estacionaplus.infrastructure.controller.response;

import co.edu.uco.estacionaplus.infrastructure.controller.response.enumerator.StatusResponse;
import co.edu.uco.estacionaplus.domain.validator.ValidateString;
import java.util.ArrayList;
import java.util.List;

public class Response<T>
{
    private StatusResponse status = StatusResponse.NOT_SUCCESSFUL;
    private List<String> messages = new ArrayList<>();
    private List<T> data;

    public StatusResponse getStatus()
    {
        return status;
    }
    public void setStatus(StatusResponse status)
    {
        this.status = status;
    }
    public List<String> getMessages()
    {
        return messages;
    }
    public void setMessages(List<String> messages)
    {
        this.messages = messages;
    }
    public List<T> getData()
    {
        return data;
    }
    public void setData(List<T> data)
    {
        this.data = data;
    }

    public void addMessage(String message)
    {
        if(!ValidateString.stringIsNull(message))
        {
            getMessages().add(message);
        }
    }
}