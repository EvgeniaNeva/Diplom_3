package network;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import models.User;

import static constants.Constants.*;

public class UserManager extends NetworkManager {
    @Step("Создание пользователя")
    public ValidatableResponse createUser(User user) {
        return request()
                .body(user)
                .when()
                .post(USER_REGISTER_URL)
                .then();
    }

    @Step("Логин пользователя")
    public ValidatableResponse loginUser(User user) {
        return request()
                .body(user)
                .when()
                .post(USER_LOGIN_URL)
                .then();
    }

    @Step("Удаление пользователя")
    public ValidatableResponse deleteUser(String accessToken) {
        ValidatableResponse response = request()
                .header("Authorization", accessToken)
                .when()
                .delete(USER_URL) // Предполагается, что для изменения данных используется PATCH
                .then();
        return response;
    }

}
