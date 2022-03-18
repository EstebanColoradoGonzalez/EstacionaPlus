package co.edu.uco.estacionaplus.infrastructure.adapter.entity;

import javax.persistence.*;

@Entity
@Table(name = "userrole")
public class UserRoleEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int code;
    private String name;

    public UserRoleEntity()
    {

    }

    public UserRoleEntity(int code, String name)
    {
        this.code = code;
        this.name = name;
    }

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}