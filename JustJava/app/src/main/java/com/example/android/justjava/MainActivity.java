    package com.example.android.justjava;

    import android.os.Bundle;
    import android.support.v7.app.ActionBarActivity;
    import android.util.Log;
    import android.view.View;
    import android.widget.CheckBox;
    import android.widget.EditText;
    import android.widget.TextView;
    import java.text.NumberFormat;

    /**
     * This app displays an order form to order coffee.
     */
    public class MainActivity extends ActionBarActivity {
     int quantity = 0;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }

        /**
         * This method displays the given price on the screen.
         */
        private void displayPrice(int number) {
            TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
            priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
        }

        /**
         * This method is called when the order button is clicked.
         */
        public void submitOrder(View view) {
            CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
            CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
            EditText customerNameinput = (EditText) findViewById(R.id.customer_name_input_view);
            String  customerName = customerNameinput.getText().toString();
            boolean hasChocolate = chocolateCheckBox.isChecked();
            boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
            int price = calculatePrice(boolean hasChocolate, boolean hasWhippedCream);
            String priceMessage =createOrderSummary(customerName,price,hasWhippedCream,hasChocolate);
            displayMessage(priceMessage);

        }

        public void increment(View view) {
            switch (quantity = quantity + 1) {
            }
            display(quantity);
        }

        public void decrement(View view) {
            if(quantity!=0)
            quantity=quantity-1;
            display(quantity);
        }

        /**
         * This method displays the given quantity value on the screen.
         */
        private void display(int number) {
            TextView quantityTextView = (TextView) findViewById(
                    R.id.quantity_text_view);
            quantityTextView.setText("" + number);
        }

        /**
         * @return total price
         */
        private int calculatePrice(boolean hasChocolate, boolean hasWhippedCream){
            int basePrice=5;
            if(hasChocolate) {
                basePrice +=2;
            }
            if(hasWhippedCream) {
                basePrice +=1;
            }

            return basePrice*quantity;
        }

        /**
         * Create summary of the order
         * @param addWhippedCream is whether the customer wants cream topping
         * @param price of the order
         * @return text summar
         */
         private String createOrderSummary(String customerName,int price, boolean addWhippedCream,boolean addChocolate){
             String priceMessage = "Name:" + customerName ;
             priceMessage +="\nAdd chocolate? " + addChocolate;
             priceMessage += "\nAdd whipped cream? " + addWhippedCream;
             priceMessage +="\nQuantity:"+ quantity;
             priceMessage += "\nTotal :$"+price;
             priceMessage += "\nThank you!";
             return priceMessage;
         }

        /**
         * This method displays the given text on the screen.
         */
        private void displayMessage(String message) {
            TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
            orderSummaryTextView.setText(message);
        }
    }