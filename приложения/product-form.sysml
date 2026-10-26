package Receptus_ProductForm {
    part def ProductForm {
        attribute title = "Новый продукт";

        part name : NameField;
        part category : CategoryField;
        part expiry : ExpiryField;
        part weight : WeightField;
        part actions : FormActions;
        part validation : ValidationMessage;
    }

    part def NameField {
        attribute text = "Название продукта";
        attribute required = "Обязательное";
    }

    part def CategoryField {
        attribute values = "Категории пользователя (можно создать свою)";
        attribute required = "Обязательное";
    }

    part def ExpiryField {
        attribute format = "ДД.ММ.ГГГГ";
        attribute rule = "Не раньше сегодняшней даты";
        attribute required = "Обязательное";
    }

    part def WeightField {
        attribute amount = "Вес необязателен";
        attribute units = "Фиксированный список: шт, г, кг, мл, л";
        attribute ifEmpty = "Для рецептов запас считается достаточным";
    }

    part def FormActions {
        attribute save = "Сохранить";
        attribute cancel = "Отмена";
    }

    part def ValidationMessage {
        attribute text = "Сообщение, если поле заполнено неверно";
    }
}
