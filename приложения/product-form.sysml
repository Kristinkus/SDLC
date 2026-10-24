package Receptus_ProductForm {
    part def ProductForm {
        attribute title = "Новый продукт";

        part name : NameField;
        part quantity : QuantityField;
        part category : CategoryField;
        part expiry : ExpiryField;
        part actions : FormActions;
        part validation : ValidationMessage;
    }

    part def NameField {
        attribute text = "Название продукта";
        attribute required = "Обязательное";
    }

    part def QuantityField {
        attribute amount = "Количество > 0";
        attribute units = "шт, г, кг, мл, л";
    }

    part def CategoryField {
        attribute values = "Молочное, овощи/фрукты, мясо/рыба, крупы/бакалея, прочее";
    }

    part def ExpiryField {
        attribute format = "ДД.ММ.ГГГГ";
        attribute rule = "Не раньше сегодняшней даты";
    }

    part def FormActions {
        attribute save = "Сохранить";
        attribute cancel = "Отмена";
    }

    part def ValidationMessage {
        attribute text = "Сообщение, если поле заполнено неверно";
    }
}
