package com.spring.cloud.mongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document(collection = "demo_collection")
public class DemoEntity implements Serializable {

    private static final long serialVersionUID = -2242257400045650858L;
    @Id
    private Long id;

    private Integer count;

    private Double sum;

    private String memo;

}
