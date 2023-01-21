public class SNAFU {
    private static SNAFU INSTANCE = null;

    public static SNAFU getINSTANCE() {
        if(INSTANCE == null){
            INSTANCE = new SNAFU();
        }

        return INSTANCE;
    }

    public int SNAFUtoDIGIT(String key){
        int value = 0;

        for(int i = key.length() - 1; i >= 0; i--){
            int index = key.length() - i;

            switch(key.charAt(i)){
                case '2' :
                    value += (2 * Math.pow(5,index - 1));
                    break;
                case '1' :
                    value += (Math.pow(5,index - 1));
                    break;
                case '0' :
                    break;
                case '-' :
                    value -= (Math.pow(5,index - 1));
                    break;
                case '=' :
                    value -= (2 * Math.pow(5,index - 1));
                    break;
            }
        }

        return value;
    }

    public String DIGITtoSNAFU(int value){
        String snafu = "";
        int remainder;

        while(value != 0){
            remainder = value % 5;
            value = value / 5;

            if(remainder > 2){
                remainder -= 5;
                value++;
            }

            switch (remainder) {
                case 2 -> snafu = "2" + snafu;
                case 1 -> snafu = "1" + snafu;
                case 0 -> snafu = "0" + snafu;
                case -1 -> snafu = "-" + snafu;
                case -2 -> snafu = "=" + snafu;
            }

        }

        return snafu;
    }
}
