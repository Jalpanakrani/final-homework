package com.localhost.categoriesinfo;

import com.localhost.swaggerinfo.CategoriesSteps;
import com.localhost.testbase.TestBase;
import com.localhost.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)

public class CategoriesCurdInfo extends TestBase {

    static String name = "kiya" + TestUtils.getRandomValue();
    static String id = "001" + TestUtils.getRandomValue();
    static int categoriesId;

    @Steps
    CategoriesSteps categoriesSteps;

    @Title("This will creat categories")
    @Test
    public void test001() {

        ValidatableResponse response = categoriesSteps.creatCategory(name, id);
        response.log().all().statusCode(201);


    }

    @Title("This will fatch single category")
    @Test
    public void test002() {

        ValidatableResponse response = categoriesSteps.getSingleCategory(id);
        response.log().all().statusCode(200);
    }

    @Title("This will update category")
    @Test
    public void test003() {
        name = name + "updated";
        ValidatableResponse response = categoriesSteps.updateCategory(name, id);
        response.log().all().statusCode(200);

    }
    @Title("This will delete category")
    @Test
    public void test004() {

        ValidatableResponse response = categoriesSteps.deletSingleCategory(id);
        response.log().all().statusCode(200);

        ValidatableResponse response1 = categoriesSteps.getSingleCategory(id);
       response1.log().all().statusCode(404);
    }
    }
