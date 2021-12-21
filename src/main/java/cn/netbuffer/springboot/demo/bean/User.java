package cn.netbuffer.springboot.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @NotNull
    @Size(max = 10)
    private String name;
    private Integer age;
    private String mobile;

    public User(String name){
        this.name=name;
    }

}
