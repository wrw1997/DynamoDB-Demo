package org.rivenstudio.dynamodemo.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import org.rivenstudio.dynamodemo.entity.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Hero repository, CRUD operation of table Hero
 *
 * @author Riven
 */
@Repository
public class HeroRepository {
    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public Hero save(Hero hero) {
        dynamoDBMapper.save(hero);
        return hero;
    }

    public Hero getHeroById(int heroId) {
        return dynamoDBMapper.load(Hero.class, heroId);
    }

    public void delete(int heroId) {
        Hero hero = dynamoDBMapper.load(Hero.class, heroId);
        dynamoDBMapper.delete(hero);
    }

    public void update(int heroId, Hero hero) {
        dynamoDBMapper.save(hero,
                new DynamoDBSaveExpression()
                        .withExpectedEntry("id",
                                new ExpectedAttributeValue(
                                        new AttributeValue().withN(String.valueOf(heroId))
                                )));
    }
}