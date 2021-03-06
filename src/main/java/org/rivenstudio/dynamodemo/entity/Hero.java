package org.rivenstudio.dynamodemo.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Hero entity class
 *
 * @author Riven
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName = "Hero")
public class Hero {

    @DynamoDBHashKey
    private int id;

    @DynamoDBAttribute
    private String name;
}
