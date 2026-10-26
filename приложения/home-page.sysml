package Receptus_Home {
    part def HomePage {
        attribute title = "Рецептус";

        part header : Header;
        part fridgeSummary : FridgeSummary;
        part wasteAlert : WasteAlert;
        part recipeSuggestions : RecipeSuggestions;
        part productList : ProductList;
        part search : SearchField;
        part addButton : AddProductButton;
    }

    part def Header {
        attribute logo = "Рецептус";
    }

    part def FridgeSummary {
        attribute productCount = "Число продуктов в холодильнике";
        attribute nearestExpiry = "Ближайший срок годности";
    }

    part def WasteAlert {
        attribute soonList = "Продукты со сроком ≤ 3 дней (только на экране)";
        attribute emptyText = "нет срочных списаний";
        attribute noPopup = "Без всплывающих уведомлений ОС";
    }

    part def RecipeSuggestions {
        attribute recipes = "Рецепты из имеющихся продуктов";
        attribute priority = "Приоритет скоропортящимся";
        attribute emptyText = "недостаточно продуктов для рецептов";
    }

    part def ProductList {
        attribute rows = "Название, категория, срок, вес (если указан)";
        attribute emptyText = "В холодильнике пока пусто";
    }

    part def SearchField {
        attribute placeholder = "Поиск по вхождению слова";
    }

    part def AddProductButton {
        attribute label = "Добавить продукт";
    }
}
