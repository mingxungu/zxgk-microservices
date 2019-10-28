package cn.com.pingtech.constant;

import org.apache.commons.lang3.StringUtils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author PingTech
 * @desc
 * @create 2019-09-09 14:43
 **/
public class Constants {

    public static final String UNKNOWN_PLATE = "无车牌";

    /**
     * 车辆主品牌
     */
    public static final Map<String, String> brandMap = new LinkedHashMap<>();

    static{
        brandMap.put("1025", "AC_Schnitzer");
        brandMap.put("1026", "阿尔法罗密欧");
        brandMap.put("1027", "阿斯顿马丁");
        brandMap.put("1028", "奥迪");
        brandMap.put("1029", "保斐利");
        brandMap.put("1030", "保时捷");
        brandMap.put("1031", "别克");
        brandMap.put("1032", "北京汽车");
        brandMap.put("1033", "北汽制造");
        brandMap.put("1034", "北汽威旺");
        brandMap.put("1035", "北汽银翔");
        brandMap.put("1036", "奔驰");
        brandMap.put("1037", "宝马");
        brandMap.put("1038", "宝骏");
        brandMap.put("1039", "宝龙");
        brandMap.put("1040", "宾利");
        brandMap.put("1041", "巴博斯");
        brandMap.put("1042", "布加迪");
        brandMap.put("1043", "本田");
        brandMap.put("1044", "标致");
        brandMap.put("1045", "比亚迪");
        brandMap.put("1046", "昌河");
        brandMap.put("1047", "长丰猎豹");
        brandMap.put("1048", "长城");
        brandMap.put("1049", "长安轿车");
        brandMap.put("1050", "DS");
        brandMap.put("1051", "东南");
        brandMap.put("1053", "大众");
        brandMap.put("1054", "大迪");
        brandMap.put("1055", "底特律电动车");
        brandMap.put("1056", "道奇");
        brandMap.put("1057", "大地");
        brandMap.put("1059", "大发");
        brandMap.put("1060", "丰田");
        brandMap.put("1061", "富奇");
        brandMap.put("1062", "弗那萨利");
        brandMap.put("1063", "法拉利");
        brandMap.put("1064", "福特");
        brandMap.put("1066", "福迪");
        brandMap.put("1067", "菲亚特");
        brandMap.put("1068", "菲斯克");
        brandMap.put("1069", "光冈");
        brandMap.put("1071", "广汽传祺");
        brandMap.put("1073", "广生");
        brandMap.put("1074", "观致");
        brandMap.put("1075", "华北");
        brandMap.put("1076", "华普");
        brandMap.put("1077", "华泰");
        brandMap.put("1078", "哈飞");
        brandMap.put("1079", "悍马");
        brandMap.put("1080", "海马");
        brandMap.put("1081", "红旗");
        brandMap.put("1083", "吉利");
        brandMap.put("1084", "吉普");
        brandMap.put("1085", "捷豹");
        brandMap.put("1086", "江南");
        brandMap.put("1088", "克莱斯勒");
        brandMap.put("1089", "凯迪拉克");
        brandMap.put("1090", "卡尔森");
        brandMap.put("1091", "康迪电动汽车");
        brandMap.put("1092", "柯尼赛格");
        brandMap.put("1093", "兰博基尼");
        brandMap.put("1094", "力帆");
        brandMap.put("1095", "劳斯莱斯");
        brandMap.put("1096", "林肯");
        brandMap.put("1097", "理念");
        brandMap.put("1098", "莲花");
        brandMap.put("1099", "蓝旗亚");
        brandMap.put("1100", "路特斯");
        brandMap.put("1101", "路虎");
        brandMap.put("1102", "铃木");
        brandMap.put("1103", "陆风");
        brandMap.put("1104", "雷克萨斯");
        brandMap.put("1105", "雷诺");
        brandMap.put("1106", "MG");
        brandMap.put("1107", "MINI");
        brandMap.put("1108", "玛莎拉蒂");
        brandMap.put("1109", "美亚");
        brandMap.put("1110", "迈凯伦");
        brandMap.put("1111", "迈巴赫");
        brandMap.put("1112", "马自达");
        brandMap.put("1113", "摩根");
        brandMap.put("1114", "纳智捷");
        brandMap.put("1115", "南京金龙");
        brandMap.put("1116", "欧宝");
        brandMap.put("1117", "讴歌");
        brandMap.put("1118", "PGO");
        brandMap.put("1119", "启辰");
        brandMap.put("1120", "奇瑞");
        brandMap.put("1121", "起亚");
        brandMap.put("1122", "前途");
        brandMap.put("1123", "日产");
        brandMap.put("1124", "瑞麒");
        brandMap.put("1125", "荣威");
        brandMap.put("1126", "如虎");
        brandMap.put("1127", "Smart");
        brandMap.put("1128", "三菱");
        brandMap.put("1129", "上汽大通");
        brandMap.put("1130", "世爵");
        brandMap.put("1131", "双环");
        brandMap.put("1132", "双龙");
        brandMap.put("1133", "斯巴鲁");
        brandMap.put("1134", "斯柯达");
        brandMap.put("1135", "萨博");
        brandMap.put("1136", "思铭");
        brandMap.put("1137", "斯达泰克");
        brandMap.put("1138", "天马");
        brandMap.put("1139", "特斯拉");
        brandMap.put("1140", "泰卡特");
        brandMap.put("1141", "腾势");
        brandMap.put("1142", "威兹曼");
        brandMap.put("1143", "威麟");
        brandMap.put("1144", "沃尔沃");
        brandMap.put("1145", "潍柴英致");
        brandMap.put("1146", "新凯");
        brandMap.put("1147", "新大地");
        brandMap.put("1148", "新雅途");
        brandMap.put("1149", "现代");
        brandMap.put("1150", "西雅特");
        brandMap.put("1151", "雪佛兰");
        brandMap.put("1152", "雪铁龙");
        brandMap.put("1154", "永源");
        brandMap.put("1155", "英特诺帝");
        brandMap.put("1156", "英菲尼迪");
        brandMap.put("1157", "野马");
        brandMap.put("1158", "游侠");
        brandMap.put("1159", "御捷");
        brandMap.put("1160", "中兴");
        brandMap.put("1161", "中华");
        brandMap.put("1162", "中客华北");
        brandMap.put("1163", "众泰");
        brandMap.put("1164", "知豆");
        brandMap.put("1165", "凯翼");
        brandMap.put("1166", "华颂");
        brandMap.put("1167", "江西五十铃");
        brandMap.put("1168", "宝沃");
        brandMap.put("1169", "陕汽通家");
        brandMap.put("1170", "汉江");
        brandMap.put("1171", "之诺");
        brandMap.put("1172", "陆地方舟");
        brandMap.put("1173", "汉腾");
        brandMap.put("1174", "雷丁");
        brandMap.put("1175", "长江");
        brandMap.put("1176", "斯威");
        brandMap.put("1177", "福汽启腾");
        brandMap.put("1178", "观致汽车");
        brandMap.put("1179", "驭胜");
        brandMap.put("1537", "安凯");
        brandMap.put("1538", "安源");
        brandMap.put("1539", "北京农用");
        brandMap.put("1540", "北奔重汽");
        brandMap.put("1541", "北方客车");
        brandMap.put("1544", "霸龙");
        brandMap.put("1546", "成功");
        brandMap.put("1547", "常隆客车");
        brandMap.put("1549", "长安商用");
        brandMap.put("1552", "东风");
        brandMap.put("1553", "东风特商(作废)");
        brandMap.put("1554", "大宇");
        brandMap.put("1555", "大运");
        brandMap.put("1556", "迪马");
        brandMap.put("1557", "东沃");
        brandMap.put("1559", "福田");
        brandMap.put("1561", "GMC");
        brandMap.put("1562", "广汽吉奥");
        brandMap.put("1563", "广汽日野轻卡");
        brandMap.put("1564", "广汽日野重卡");
        brandMap.put("1566", "华菱");
        brandMap.put("1568", "恒天汽车");
        brandMap.put("1569", "恒通客车");
        brandMap.put("1570", "汇众");
        brandMap.put("1571", "海格");
        brandMap.put("1573", "海欧");
        brandMap.put("1574", "航天圆通");
        brandMap.put("1575", "航天");
        brandMap.put("1576", "黄海");
        brandMap.put("1577", "黑豹");
        brandMap.put("1578", "九龙");
        brandMap.put("1579", "江淮");
        brandMap.put("1580", "江环");
        brandMap.put("1581", "江铃");
        brandMap.put("1582", "江铃(作废)");
        brandMap.put("1583", "金旅客车");
        brandMap.put("1584", "金杯");
        brandMap.put("1585", "金龙");
        brandMap.put("1586", "凯马");
        brandMap.put("1587", "卡威");
        brandMap.put("1588", "开瑞");
        brandMap.put("1590", "联合");
        brandMap.put("1592", "曼集团");
        brandMap.put("1594", "农用车");
        brandMap.put("1595", "南京依维柯");
        brandMap.put("1596", "南骏");
        brandMap.put("1597", "庆铃");
        brandMap.put("1598", "青年汽车");
        brandMap.put("1599", "三一重工");
        brandMap.put("1600", "三环十通");
        brandMap.put("1603", "上汽依维柯红岩");
        brandMap.put("1604", "上饶客车");
        brandMap.put("1605", "实力客车");
        brandMap.put("1606", "少林客车");
        brandMap.put("1607", "时代汽车");
        brandMap.put("1608", "时风");
        brandMap.put("1609", "申沃");
        brandMap.put("1610", "申龙客车");
        brandMap.put("1611", "神野");
        brandMap.put("1612", "舒驰客车");
        brandMap.put("1613", "陕汽");
        brandMap.put("1614", "斯堪尼亚");
        brandMap.put("1615", "唐骏");
        brandMap.put("1616", "太湖客车");
        brandMap.put("1618", "同心汽车");
        brandMap.put("1619", "万丰");
        brandMap.put("1620", "五征");
        brandMap.put("1621", "五菱");
        brandMap.put("1622", "武夷");
        brandMap.put("1624", "五环");
        brandMap.put("1626", "徐工");
        brandMap.put("1629", "一汽");
        brandMap.put("1630", "亚星");
        brandMap.put("1631", "依维柯");
        brandMap.put("1632", "友谊客车");
        brandMap.put("1633", "宇通");
        brandMap.put("1634", "扬子");
        brandMap.put("1635", "燕台");
        brandMap.put("1636", "跃进");
        brandMap.put("1637", "英田");
        brandMap.put("1639", "中国重汽");
        brandMap.put("1641", "中通客车");
        brandMap.put("1642", "中顺");
        brandMap.put("1643", "重汽王牌");
        brandMap.put("1644", "中大");
        brandMap.put("1645", "广通客车");
        brandMap.put("1646", "精功重卡");
        brandMap.put("1647", "五洲龙");
        brandMap.put("1648", "客车");
        brandMap.put("1652", "牡丹汽车");
        brandMap.put("1653", "楚风汽车");
        brandMap.put("1654", "吉江汽车");
        brandMap.put("1655", "上汽仪征");
        brandMap.put("1656", "越西汽车");
        brandMap.put("1657", "神马汽车");
        brandMap.put("1658", "江西消防");
        brandMap.put("1659", "顺丰汽车");
        brandMap.put("1660", "衡山汽车");
        brandMap.put("1674", "东方红");
        brandMap.put("1675", "尼奥普兰");
        brandMap.put("1676", "轻骑");
        brandMap.put("1677", "卡车");
        brandMap.put("1678", "特型车");
        brandMap.put("1679", "拖车");
        brandMap.put("1681", "万达客车");
        brandMap.put("1684", "四川现代");
        brandMap.put("1685", "奥驰");
        brandMap.put("1686", "骏威客车");
        brandMap.put("1687", "一汽柳特");
        brandMap.put("1688", "万象");
        brandMap.put("1690", "力帆时骏");
        brandMap.put("1691", "长安");
        brandMap.put("1692", "中联重工");
        brandMap.put("1693", "银隆");
        brandMap.put("1694", "嘉川汽车");
    }

    /**
     * 车牌颜色
     */
    public enum PlateColor {
        WHITE("0","白色"),
        YELLOW("1","黄色"),
        BLUE("2","蓝色"),
        BLACK("3","黑色"),
        UNKNOWN("4","未识别"),
        GREEN("5","绿色"),
        ;
        private String value;
        private String text;

        PlateColor(String value,String text){
            this.value = value;
            this.text =text;
        }

        public String getValue() {
            return value;
        }

        public String getText() {
            return text;
        }

        public static String getTextByValue(String value){
            if(StringUtils.isNotEmpty(value)){
                PlateColor[] values = PlateColor.values();
                for(PlateColor plateColor : values){
                    if(plateColor.value.equals(value)){
                        return plateColor.text;
                    }
                }
            }
            return UNKNOWN.text;
        }
    }

    /**
     * 车辆颜色
     */
    public enum VehicleColor {
        UNKNOWN("0","未知"),
        WHITE("1","白色"),
        SILVERY("2","银色"),
        GRAY("3","灰色"),
        BLACK("4","黑色"),
        RED("5","红色"),
        BLUE_DEEP("6","深蓝"),
        BLUE("7","蓝色"),
        YELLOW("8","黄色"),
        GREEN("9","绿色"),
        BROWN("10","棕色"),
        PINK("11","粉色"),
        PURPLE("12","紫色"),
        GRAY_DEEP("13","深灰"),
        CYAN("14","青色"),
        ;
        private String value;
        private String text;

        VehicleColor(String value,String text){
            this.value = value;
            this.text =text;
        }

        public String getValue() {
            return value;
        }

        public String getText() {
            return text;
        }

        public static String getTextByValue(String value){
            if(StringUtils.isNotEmpty(value)){
                VehicleColor[] values = VehicleColor.values();
                for(VehicleColor vehicleColor : values){
                    if(vehicleColor.value.equals(value)){
                        return vehicleColor.text;
                    }
                }
            }
            return UNKNOWN.text;
        }
    }

    /**
     * 车头方向
     */
    public enum VehicleHeadDirection {
        UNKNOWN("0","未知"),
        POSITIVE("1","正向"),
        NEGATIVE("2","背向"),
        ;
        private String value;
        private String text;

        VehicleHeadDirection(String value,String text){
            this.value = value;
            this.text =text;
        }

        public String getValue() {
            return value;
        }

        public String getText() {
            return text;
        }

        public static String getTextByValue(String value){
            if(StringUtils.isNotEmpty(value)){
                VehicleHeadDirection[] values = VehicleHeadDirection.values();
                for(VehicleHeadDirection vehicleHead : values){
                    if(vehicleHead.value.equals(value)){
                        return vehicleHead.text;
                    }
                }
            }
            return UNKNOWN.text;
        }
    }

    /**
     * 车牌类型
     */
    public enum PlateType {
        TYPE_0("0","未知"),
        TYPE_1("1","92式民用车"),
        TYPE_2("2","警用车"),
        TYPE_3("3","上下军车"),
        TYPE_4("4","92式武警车"),
        TYPE_5("5","左右军车"),

        TYPE_7("7","02式个性化车"),
        TYPE_8("8","黄色双行尾牌"),
        TYPE_9("9","04式新军车"),
        TYPE_10("10","使馆车"),
        TYPE_11("11","一行结构的新WJ车"),
        TYPE_12("12","双行结构的新WJ车"),
        TYPE_13("13","黄色1225农用车"),
        TYPE_14("14","绿色1325农用车"),
        TYPE_15("15","黄色1325农用车"),
        TYPE_16("16","摩托车"),
        TYPE_17("17","新能源车"),
        TYPE_18("18","2012式一行结构新WJ总部车牌类型（单行）"),
        TYPE_19("19","2012式两行结构新WJ总部车牌类型（双行）"),
        TYPE_20("20","民航车牌类型"),

        TYPE_100("100","教练车"),
        TYPE_101("101","临时行驶车"),
        TYPE_102("102","挂车"),
        TYPE_103("103","领馆汽车"),
        TYPE_104("104","港澳出入车"),
        TYPE_105("105","临时入境车"),
        ;
        private String value;
        private String text;

        PlateType(String value,String text){
            this.value = value;
            this.text =text;
        }

        public String getValue() {
            return value;
        }

        public String getText() {
            return text;
        }

        public static String getTextByValue(String value){
            if(StringUtils.isNotEmpty(value)){
                PlateType[] values = PlateType.values();
                for(PlateType plateType : values){
                    if(plateType.value.equals(value)){
                        return plateType.text;
                    }
                }
            }
            return TYPE_0.text;
        }
    }

    /**
     * 车辆类型
     */
    public enum VehicleType {
        TYPE_0("0","未知"),
        TYPE_1("1","客车(大型)"),
        TYPE_2("2","货车(大型)"),
        TYPE_3("3","轿车(小型)"),
        TYPE_4("4","面包车"),
        TYPE_5("5","小货车"),
        TYPE_6("6","行人"),
        TYPE_7("7","二轮车"),
        TYPE_8("8","三轮车"),
        TYPE_9("9","SUV/MPV"),
        TYPE_10("10","中型客车"),
        ;
        private String value;
        private String text;

        VehicleType(String value,String text){
            this.value = value;
            this.text =text;
        }

        public String getValue() {
            return value;
        }

        public String getText() {
            return text;
        }

        public static String getTextByValue(String value){
            if(StringUtils.isNotEmpty(value)){
                VehicleType[] values = VehicleType.values();
                for(VehicleType vehicleType : values){
                    if(vehicleType.value.equals(value)){
                        return vehicleType.text;
                    }
                }
            }
            return TYPE_0.text;
        }
    }
}

