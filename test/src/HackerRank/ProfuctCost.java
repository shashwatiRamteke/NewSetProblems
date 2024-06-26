package HackerRank;

import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.joining;


class Result5 {

    /*
     * Complete the 'findLowestPrice' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. 2D_STRING_ARRAY products
     *  2. 2D_STRING_ARRAY discounts
     */

    public static int findLowestPrice(List<List<String>> products, List<List<String>> discounts) {
        // Write your code here
        int noOfProducts = products.size();

        int finalTotalOfMinOffering =0;

        for(int i=0;i<noOfProducts;i++){
            List<String> listOfDisWithProduct = products.get(i);
            int calculateMinDiscount = Integer.parseInt(listOfDisWithProduct.get(0));
            for(int j=1; j< listOfDisWithProduct.size();j++){
                String discountName = listOfDisWithProduct.get(j);
                int currentTagsValue = 0;
                if(!discountName.equals("EMPTY")) {
                    for(List<String> discountType:discounts) {
                        if (discountType.get(0).equals(discountName)) {
                            if (discountType.get(1).equals("0")) {
                                if (!discountType.get(1).equals("EMPTY")) {
                                    currentTagsValue = Integer.parseInt(discountType.get(2));
                                }
                            }
                            if (discountType.get(1).equals("1")) {
                                double percentage = (double) Integer.parseInt(discountType.get(2)) / 100;
                                if (listOfDisWithProduct.get(0).contains(".")) {
                                    currentTagsValue = (int) (Float.parseFloat(listOfDisWithProduct.get(0)) - (percentage * Float.parseFloat(listOfDisWithProduct.get(0))));
                                } else {
                                    currentTagsValue = (int) (Integer.parseInt(listOfDisWithProduct.get(0)) - (percentage * Integer.parseInt(listOfDisWithProduct.get(0))));
                                }
                            }
                            if (discountType.get(1).equals("2")) {
                                currentTagsValue = Integer.parseInt(listOfDisWithProduct.get(0)) - (Integer.parseInt(discountType.get(2)));
                            }
                            if (currentTagsValue < calculateMinDiscount) {
                                calculateMinDiscount = currentTagsValue;
                            }
                        }
                    }
                }
                else{
                    currentTagsValue= Integer.parseInt(listOfDisWithProduct.get(0));
                    if (currentTagsValue < calculateMinDiscount) {
                        calculateMinDiscount = currentTagsValue;
                    }
                }
            }
            finalTotalOfMinOffering += calculateMinDiscount;
        }
        return finalTotalOfMinOffering;
    }

}

public class ProfuctCost {
    public static void main(String[] args) throws IOException {

        int productsRows = 6;
        int productsColumns = 2;

        List<List<String>> products = new ArrayList<>();
        //ArrayList<String> productinternal = new ArrayList<>();


        for(int i=0;i<2;i++) {
            ArrayList<String> productinternal = new ArrayList<String>();
            if (i == 0){
                productinternal.add("10");
                productinternal.add("sale");
                productinternal.add("january-sale");

            }
            if(i==1) {
                productinternal.add("200");
                productinternal.add("sale");
                productinternal.add("EMPTY");
            }

            products.add(productinternal);
        }

        int discountsRows = 2;
        int discountsColumns = 3;

        List<List<String>> discounts = new ArrayList<>();

        for(int i=0;i<2;i++) {
            ArrayList<String> discountsinternal = new ArrayList<String>();
            if (i == 0){
                discountsinternal.add("sale");
                discountsinternal.add("0");
                discountsinternal.add("10");

            }
            if(i==1) {
                discountsinternal.add("january-sale");
                discountsinternal.add("1");
                discountsinternal.add("10");
            }

            discounts.add(discountsinternal);
        }


        int result = Result5.findLowestPrice(products, discounts);

       System.out.println(result);
    }
}