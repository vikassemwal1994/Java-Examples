 static int x = 0;

    public static void main(String[] args) {

//        round_Off_Integers();

        sorted_Array_AsPer_Occurrence();


    }

    private static void round_Off_Integers(){
        String text = "<p>I don't want this to be bold</p>";
        System.out.println(text);
        text = text.replaceAll("\\<.*?\\>", "");
        System.out.println(text);

        float amount = 7080;
        float total_amount = 0;
        float count = 2;

        float total_count_amount = 0;
        float total_gst_amount = 0;
        float total_count_amount_gst = 0;
        int total_count_amount_gst_round = 0;

        total_count_amount = amount * count;
        System.out.print("total_count_amount --- ");
        System.out.println(total_count_amount);

        total_gst_amount = total_count_amount * 18 / 100;
        System.out.print("total_gst_amount --- ");
        System.out.println(total_gst_amount);

        total_count_amount_gst = total_count_amount + total_gst_amount;
        System.out.print("total_count_amount_gst --- ");
        System.out.println(total_count_amount_gst);

        total_count_amount_gst_round = (int) Math.round(total_count_amount_gst);
        System.out.print("total_count_amount_gst_round --- ");
        System.out.println(total_count_amount_gst_round);

    }

    ///-----
    private static void sorted_Array_AsPer_Occurrence() {
        //step 1: numbers array = {6,5,6,2,4,1,8,7,5,6,9,5,4,2,1,6}
        //step 2: 2D array :[6][4]
        //                  [5][3]
        //                  [2][2]
        //                  [4][2]
        //                  [1][2]
        //                  [8][1]
        //                  [7][1]
        //                  [9][1]
        // step 3: then sort
        int[] numbers_array = {6, 5, 6, 2, 4, 1, 8, 7, 5, 6, 9, 5, 4, 2, 1, 6};
        int[][] number_array_2d = new int[numbers_array.length][2];

        sort(numbers_array);

        System.out.println("number array : ");
        System.out.println(Arrays.toString(numbers_array));

        number_array_2d[x][0] = numbers_array[0];
        number_array_2d[x][1]= 1;

        //querry array
        for (int i = 1; i < numbers_array.length; i++) {

            if (numbers_array[i] == numbers_array[i - 1]) {
                number_array_2d[x][1] = number_array_2d[x][1] + 1;
            } else {
                x++;
                number_array_2d[x][0] = numbers_array[i];
                number_array_2d[x][1]= 1;
            }

        }
        System.out.println("sorted 2D array : ");
        System.out.println(Arrays.deepToString(number_array_2d));

        sort2dArray(number_array_2d);

        System.out.println("sorted 2D array as per occurance : ");
        System.out.println(Arrays.deepToString(number_array_2d));

    }

    private static int[] sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int t;
                    t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                }
            }
        }
        return a;
    }

    private static int[][] sort2dArray(int[][] b){
        int c[] = new int[2];
        for(int i =0; i<x; i++){
            for(int j=i; j<x; j++){
                if (b[i][1]< b[j][1]){
                    c = b[i];
                    b[i] = b[j];
                    b[j] = c;
                }
            }
        }

        return b;
    }
    ///----

    private static void occurance_char_inString(){


    }
