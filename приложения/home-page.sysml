package Kladovaya_Home {
    part def HomePage {
        attribute title = "Кладовая";

        part header : Header;
        part fridgeSummary : FridgeSummary;
        part wasteAlert : WasteAlert;
        part recipeSuggestions : RecipeSuggestions;
        part productList : ProductList;
        part addButton : AddProductButton;
    }

    part def Header {
        attribute logo = "Кладовая";
    }

    part def FridgeSummary {
        attribute productCount = "Число продуктов в холодильнике";
        attribute nearestExpiry = "Ближайший срок годности";
    }

    part def WasteAlert {
        attribute soonList = "Продукты со сроком ≤ 3 дней";
        attribute emptyText = "нет срочных списаний";
    }

    part def RecipeSuggestions {
        attribute recipes = "Рецепты из имеющихся продуктов";
        attribute priority = "Приоритет скоропортящимся";
        attribute emptyText = "недостаточно продуктов для рецептов";
    }

    part def ProductList {
        attribute rows = "Название, количество, категория, срок годности";
        attribute emptyText = "В холодильнике пока пусто";
    }

    part def AddProductButton {
        attribute label = "Добавить продукт";
    }
}
