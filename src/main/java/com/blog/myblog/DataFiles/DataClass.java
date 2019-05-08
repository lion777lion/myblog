package com.blog.myblog.DataFiles;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.websocket.Decoder;
import java.io.IOException;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="BlogTable")
public class DataClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long Id;

    @NotNull
    String name;

    @NotNull
    String message;

    @Lob
    @NotNull
    @Type(type="org.hibernate.type.BinaryType")
    byte[] file;

    @NotNull
    @DateTimeFormat(pattern = "yyyy/MM/dd hh:mm")
    LocalDateTime time;

}
