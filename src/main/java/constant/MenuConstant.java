package constant;

public class MenuConstant {



    private MenuConstant() {
    }

    public static final String CURSOR = "-->";

    public static final String EXIT = "exit";

    public static final String ALL = "all";

    public static final String THREE = "3";

    public static final String TWO = "2";

    public static final String ONE = "1";

    public static final String TOTAL_POWER = "\nСуммарная потребляемая мощность: ";

    public static final String TOTAL_DEVICES = " вт. Количество включенных приборов в сеть: ";

    public static final String WRONG_NUMBER = "\nВведено неверное значение!\n";

    public static final String BUY_SOMETHING = ", желаете купить устройство?";

    public static final String LIST_IS_EMPTY = "\nСписок устройств в вашей квартире пуст!\n";

    public static final String DEVICE_ADDED = "\nУстройство успешно куплено!";

    public static final String DEVICE_NOT_ADDED = "\nОшибка! Устройство не куплено!";

    public static final String FOUNDED_LIST = "\nСписок найденных устройств:";

    public static final String SORTED_LIST = "\nСписок отсортерованных устройств по мощности:";

    public static final String MENU_REGISTRATION = """
                        
            ******** Главное меню *********
            * Добро пожаловать в квартиру!*
            *** Введите "exit" для выхода ***
            ***  Как к вам обращаться?  ***""";

    public static final String USER_MENU = """
                           
                  ******** Меню пользователя ********
             * Введите 1 для просмотра товаров магазина *
            * Введите 2 для просмотра купленных приборов  *
               ******** Введите 3 для выхода *******""";

    public static final String WRONG_USERNAME = """
                           
                  ***** Неверно введены данные! *****
                 * Имя пользователя должно содержать: *
              * от 3 до 15 буквенных или циферных значений *
            * допускается использование нижнего подчеркивания *""";

    public static final String SHOP_MENU = """
                     
            ***** Добро пожаловать в магазин! *****
                 * Список имеющихся товаров:  *""";

    public static final String CURRENT_USER_DEVICE_LIST = """
                     
            *** Список устройств в вашей квартире ***""";

    public static final String MAKE_CHOOSE = """
            ** введите номер для покупки **
              *** или "exit" для выхода ***""";

    public static final String USER_DEVICE_ACTIONS = """
                           
                           ******** Меню пользователя ********
                * Введите 1 для включения/выключения приборов в сеть *
                        * Введите 2 для поиска приборов  *
                       ******* Введите 3 для выхода в меню ******""";

    public static final String SEARCH_MENU_BOT = """
                           
                       ******** Меню поиска ********
                * Введите нижний диапозон мощности прибора *
                ******* Введите "exit" для выхода в меню ******""";

    public static final String SEARCH_MENU_TOP = """
                           
                       ******** Меню поиска ********
                * Введите верхний диапозон мощности прибора *
                ******* Введите "exit" для выхода в меню ******""";

    public static final String TURN_OFF_ON_MENU = """
                           
                    ******** Меню включения/выключения ********
                   * Введите "all" для включения/выключения всех приборов *
                    * Введите номер прибора для его включения/выключения *
                  ****** Введите "exit" для выхода в меню ******""";
}
