package entity.device;

public enum DeviceType {

    FRIDGE_ATLANT(200) {
        @Override
        public String getDeviceName() {
            return "холодильник Atlant";
        }
    },
    FRIDGE_LG(300){
        @Override
        public String getDeviceName() {
            return "холодильник LG";
        }
    },
    FRIDGE_SAMSUNG(250){
        @Override
        public String getDeviceName() {
            return "холодильник Samsung";
        }
    },

    KETTLE_TEFAL(2200){
        @Override
        public String getDeviceName() {
            return "чайник Tefal";
        }
    },
    KETTLE_HOLT(2150){
        @Override
        public String getDeviceName() {
            return "чайник Holt";
        }
    },
    KETTLE_MAUNFELD(2250){
        @Override
        public String getDeviceName() {
            return "чайник Maunfeld";
        }
    },

    IRON_BRAUN(3000){
        @Override
        public String getDeviceName() {
            return "утюг Braun";
        }
    },
    IRON_PHILIPS(2900){
        @Override
        public String getDeviceName() {
            return "утюг Philips";
        }
    },
    IRON_POLARIS(2500){
        @Override
        public String getDeviceName() {
            return "утюг Polaris";
        }
    },

    MICROWAVE_SAMSUNG(800){
        @Override
        public String getDeviceName() {
            return "микроволновка Samsung";
        }
    },
    MICROWAVE_BOSCH(900){
        @Override
        public String getDeviceName() {
            return "микроволновка Bosch";
        }
    },
    MICROWAVE_HANSA(700){
        @Override
        public String getDeviceName() {
            return "микроволновка Hansa";
        }
    },

    OVEN_GEFEST(2600){
        @Override
        public String getDeviceName() {
            return "духовка Gefest";
        }
    },
    OVEN_ELECTROLUX(2700){
        @Override
        public String getDeviceName() {
            return "духовка Electrolux";
        }
    },
    OVEN_BOSCH(2550){
        @Override
        public String getDeviceName() {
            return "духовка Bosch";
        }
    },

    TV_SONY(200){
        @Override
        public String getDeviceName() {
            return "телевизор Sony";
        }
    },
    TV_HORIZONT(150){
        @Override
        public String getDeviceName() {
            return "телевизор Horizont";
        }
    },
    TV_XIAOMI(250){
        @Override
        public String getDeviceName() {
            return "телевизор Xiaomi";
        }
    };


    private final int devicePower;

    DeviceType(int devicePower) {
        this.devicePower = devicePower;
    }

    public int getDevicePower() {
        return devicePower;
    }

    public abstract String getDeviceName();
}
