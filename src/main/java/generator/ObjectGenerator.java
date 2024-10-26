package generator;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import io.qameta.allure.Step;
import models.User;
import org.apache.commons.lang3.RandomStringUtils;

public class ObjectGenerator {
    @Step("Генерация рандомного пользователя")
    public static @NotNull User generateUser() {
        final User user = new User();
        user.setName(RandomStringUtils.random(10, true, false));
        user.setEmail(RandomStringUtils.random(10, true, false) + "@gmail.com");
        user.setPassword(RandomStringUtils.random(10, true, true));
        return user;
    }
}
