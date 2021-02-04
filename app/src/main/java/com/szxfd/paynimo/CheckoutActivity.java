package com.szxfd.paynimo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.paynimo.android.payment.PaymentActivity;
import com.paynimo.android.payment.PaymentModesActivity;
import com.paynimo.android.payment.model.Checkout;
import com.paynimo.android.payment.util.Constant;

import java.util.Date;

public class CheckoutActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_PAYTM = 0x00;

    private static final String TAG = "CheckoutActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.merchant_activity_checkout);

        findViewById(R.id.checkout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPay();
            }
        });
    }



    private void startPay() {
//        Checkout checkout = new Checkout();
//        // setting values to checkout object
//        //Case 1: Mandatory Fields
//        // setting Merchant fields values
//        checkout.setMerchantIdentifier("T515688");  //where T1234 is the MERCHANT CODE, update it with Merchant Code provided by TPSL
//        checkout.setTransactionIdentifier("TXN001"); //where TXN001 is the Merchant Transaction Identifier, it should be different for each transaction (alphanumeric value, no special character allowed)
//        checkout.setTransactionReference("ORD0001"); //where ORD0001 is the Merchant Transaction Reference number
//        checkout.setTransactionType(PaymentActivity.TRANSACTION_TYPE_SALE); //Transaction Type
//        checkout.setTransactionSubType(PaymentActivity.TRANSACTION_SUBTYPE_DEBIT); //Transaction Subtype
//        checkout.setTransactionCurrency("INR"); //Currency Type
//        checkout.setTransactionAmount("1.00"); //Transaction Amount
//        checkout.setTransactionDateTime("24-03-2020"); //Transaction Date
//        // setting Consumer fields values
//        checkout.setConsumerIdentifier("1234567890"); //Consumer Identifier, default value "", set this value as application user name if you want Instrument Vaulting, SI on Cards. Consumer ID should be alpha-numeric value with no space
//        checkout.setConsumerEmailID("test@gmail.com"); //Consumer Email ID
//        checkout.setConsumerMobileNumber("7620656789"); //Consumer Mobile Number
//        checkout.setConsumerAccountNo("");//Account Number, default value "". For eMandate, you can set this value here or can be set later in SDK.
//        // setting Consumer Cart Item
//        // checkout.addCartItem("ProductID", "ProductAmount", "ProductSurchargeOrDiscountAmount", "CommisionAmount", "ProductSKU", "ProductReference", "ProductDescriptor", "ProductProviderID");
//        // setting Consumer Cart Item1
//        checkout.addCartItem("First", "1.00", "0.0", "0.0", "SMSG2015-01-12345", "Mobile", "HTC Desire", "www.flipkart.com");
//        checkout.setCartDescription("{name:User1}{accountNo:1234567890}");
//
//        //Case 2: For Standing Instruction from Merchant
//        // setting Standing Instruction Payment fields’ values
//
//        // ACTION Y for SI enabled from merchant end and N for SI disabled
//        checkout.setPaymentInstructionAction("Y");
//        // Amount type -> Fixed - F, Maximum - M
//        checkout.setPaymentInstructionType("F");
//        // Max amount
//        checkout.setPaymentInstructionLimit("1000.00");
//
//        // Payment Frequency
//        // DAIL - Daily, Week - Weekly, MNTH - Monthly,QURT - Quarterly, MIAN - Semi annually, YEAR - Yearly, BIMN - Bi-monthly,ADHO - As and when presented
//        checkout.setPaymentInstructionFrequency("ADHO");
//        // Debit start date, format -> 'DD-MM-YYYY'
//        checkout.setPaymentInstructionStartDateTime("30-03-2020");
//        // Debit end date, format -> 'DD-MM-YYYY'
//        checkout.setPaymentInstructionEndDateTime("24-03-2021");

//        //For eSign(OTP and Biometric) transactions, set below parameters
//        checkout.setConsumerAccountHolderName("Rahul");// Account Holder Name (optional)
//        // Account Type (optional) Saving - Saving, Current - Current, Cash Credit - CC
//        checkout.setConsumerAccountType("CC");
//        // Bank IFSC Code (optional)
//        checkout.setPaymentInstrumentIFSC("ICIC0000015");
//        // Set Debit Date Flag (optional)
//        // Flag Y for setting mandate Debit Date
//        // Flag N/”” for not setting Debit Date
//        checkout.setPaymentInstructionDebitFlag("Y");

//        // For eNACH transactions, set below mandatory parameters
//        checkout.setConsumerAccountHolderName("Rahul");
//        checkout.setConsumerAccountType("CC");
//        checkout.setConsumerAccountNo("7620656789");
//        // For eNACH transactions, you can set below optional parameters
//        checkout.setConsumerEmailID("test@gmail.com"); //Consumer Email ID
//        checkout.setConsumerMobileNumber("7620656789"); //Consumer Mobile Number
//        checkout.setConsumerPan("BYTUI1144J"); //Consumer PAN
//        checkout.setConsumerPhoneNumber("02225458585"); //Consumer Phone Number

        //Case 3 (a): Data Capturing Page at Merchant End For - New Card
//        checkout.setTransactionMerchantInitiated("Y");
//        checkout.setPaymentInstrumentIdentifier("4111111111111111");
//        checkout.setPaymentInstrumentExpiryMonth("03");
//        checkout.setPaymentInstrumentExpiryYear("2020");
//        checkout.setPaymentInstrumentVerificationCode("123");
//        checkout.setPaymentInstrumentHolderName("Rahul");
//        checkout.setTransactionIsRegistration("Y");

//        //Case 3 (b): Data Capturing Page at Merchant End For - Saved Card
//        checkout.setTransactionMerchantInitiated("Y");
//        checkout.setPaymentInstrumentToken("123234");
//        checkout.setPaymentInstrumentVerificationCode("123");
        //        //Case 3 (c): Data Capturing Page at Merchant End For –Netbanking/Wallets/EMI/CashCards/UPI/mVISA
//        checkout.setTransactionMerchantInitiated("Y");
//        checkout.setPaymentMethodToken("123234");

        Checkout checkout = new Checkout();
        checkout.setMerchantIdentifier("T515688");
        checkout.setTransactionIdentifier(String.valueOf(new Date().getTime()));
        checkout.setTransactionReference("ORD0001");
        checkout.setTransactionType(PaymentActivity.TRANSACTION_TYPE_SALE);
        checkout.setTransactionSubType(PaymentActivity.TRANSACTION_SUBTYPE_DEBIT);
        checkout.setTransactionCurrency("INR");
        checkout.setTransactionAmount("50");
        checkout.setTransactionDateTime("03-04-2020");
        checkout.setConsumerIdentifier("10086");
        checkout.setConsumerEmailID("rohitbhard@gmail.com");
        checkout.setConsumerMobileNumber("8826120009");
        checkout.setConsumerAccountNo("");
        checkout.addCartItem("FIRST", "1", "0.0", "0.0", "", "", "", "");
        checkout.setPaymentInstructionAction("Y");
        checkout.setPaymentInstructionStartDateTime("05-02-2021");
        checkout.setPaymentInstructionEndDateTime("25-02-2050");
        checkout.setPaymentInstructionLimit("100");
        checkout.setPaymentInstructionFrequency("ADHO");
        checkout.setPaymentInstructionType("F");

        checkout.setConsumerAccountHolderName("ROHIT BHARDWAJ");
        checkout.setConsumerAccountType("Saving");
        checkout.setConsumerAccountNo("031401543318");
        checkout.setConsumerPan("AMDPB1252C"); //Consumer PAN
        checkout.setConsumerPhoneNumber("8826120009"); //Consumer Phone Number

        Intent authIntent = PaymentModesActivity.Factory.getAuthorizationIntent(getApplicationContext(), true);
        // Checkout Object
        Log.d("Checkout Request Object", checkout.getMerchantRequestPayload().toString());
        authIntent.putExtra(Constant.ARGUMENT_DATA_CHECKOUT, checkout);
        // Public Key
        authIntent.putExtra(PaymentActivity.EXTRA_PUBLIC_KEY, "1234-6666-6789-56");
        // Requested Payment Mode
        authIntent.putExtra(PaymentActivity.EXTRA_REQUESTED_PAYMENT_MODE,
                PaymentActivity.PAYMENT_METHOD_NETBANKING);

        PaymentModesActivity.Settings settings = new PaymentModesActivity.Settings();
        authIntent.putExtra(Constant.ARGUMENT_DATA_SETTING, settings);

        startActivityForResult(authIntent, PaymentActivity.REQUEST_CODE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Check which request we're responding to
        if (requestCode == PaymentActivity.REQUEST_CODE) {
            // Make sure the request was successful
            if (resultCode == PaymentActivity.RESULT_OK) {
                Log.d(TAG, "Result Code :" + RESULT_OK);
                if (data != null) {
                    try {
                        Checkout checkout_res = (Checkout) data
                                .getSerializableExtra(Constant
                                        .ARGUMENT_DATA_CHECKOUT);
                        Log.d("Checkout Response Obj", checkout_res
                                .getMerchantResponsePayload().toString());
                        String transactionSubType = checkout_res.getMerchantRequestPayload().getTransaction().getSubType();
                        System.out.println("Payment type => " + transactionSubType);
                        // Transaction Completed and Got SUCCESS
                        if (checkout_res.getMerchantResponsePayload().getPaymentMethod().getPaymentTransaction().getStatusCode().equalsIgnoreCase(
                                PaymentActivity.TRANSACTION_STATUS_SALES_DEBIT_SUCCESS)) {
                            Toast.makeText(getApplicationContext(), "Transaction Status - Success", Toast.LENGTH_SHORT).show();
                            Log.v("TRANSACTION STATUS=>", "SUCCESS");
                            System.out.println("TRANSACTION_STATUS_SALES_DEBIT_SUCCESS");
                            /**
                             * TRANSACTION STATUS - SUCCESS (status code
                             * 0300 means success), NOW MERCHANT CAN PERFORM
                             * ANY OPERATION OVER SUCCESS RESULT
                             */
                            if (checkout_res.getMerchantResponsePayload().
                                    getPaymentMethod().getPaymentTransaction().
                                    getInstruction().getId() != null && checkout_res.getMerchantResponsePayload().
                                    getPaymentMethod().getPaymentTransaction().
                                    getInstruction().getId().isEmpty()) {
                                Log.v("TRANSACTION SI STATUS=>",
                                        "SI Transaction Not Initiated");
                                System.out.println("TRANSACTION SI  SI Transaction Not Initiated");
                            } else if (checkout_res.getMerchantResponsePayload().
                                    getPaymentMethod().getPaymentTransaction().
                                    getInstruction().getId() != null && !checkout_res.getMerchantResponsePayload().
                                    getPaymentMethod().getPaymentTransaction().
                                    getInstruction().getId().isEmpty()) {
                            /*
                              SI TRANSACTION STATUS - SUCCESS (Mandate  Registration ID received means success)
                             */
                                System.out.println("TRANSACTION SI SUCCESS (Mandate  Registration ID received means success)");
                                Log.v("TRANSACTION SI STATUS=>", "SUCCESS");
                            }
                        } else if (checkout_res
                                .getMerchantResponsePayload().getPaymentMethod().getPaymentTransaction().getStatusCode().equalsIgnoreCase(
                                        PaymentActivity.TRANSACTION_STATUS_DIGITAL_MANDATE_SUCCESS
                                )) {
                            Toast.makeText(getApplicationContext(), "Transaction Status - Success", Toast.LENGTH_SHORT).show();
                            Log.v("TRANSACTION STATUS=>", "SUCCESS");
                            System.out.println("TRANSACTION_STATUS_DIGITAL_MANDATE_SUCCESS");
                            /**
                             * TRANSACTION STATUS - SUCCESS (status code
                             * 0398 means success), NOW MERCHANT CAN PERFORM
                             * ANY OPERATION OVER SUCCESS RESULT
                             */
                            if (checkout_res.getMerchantResponsePayload().
                                    getPaymentMethod().getPaymentTransaction().
                                    getInstruction().getId() != null
                                    && !checkout_res
                                    .getMerchantResponsePayload().getPaymentMethod().getPaymentTransaction().getInstruction().getId().isEmpty()) {
                                /**
                                 * SI TRANSACTION STATUS - SUCCESS (status
                                 * code 0300 means success)
                                 */
                                Log.v("TRANSACTION SI STATUS=>",
                                        "INITIATED");
                                System.out.println("Transaction Digital Mandate Success");
                            } else {
                                System.out.println("Transaction Digital Mandate Failure");
                                /**
                                 * SI TRANSACTION STATUS - Failure (status
                                 * code OTHER THAN 0300 means failure)
                                 */
                                Log.v("TRANSACTION SI STATUS=>", "FAILURE");
                            }
                        } else {
                            System.out.println("Bank Error Failure");
                            // some error from bank side
                            Log.v("TRANSACTION STATUS=>", "FAILURE");
                            Toast.makeText(getApplicationContext(),
                                    "Transaction Status - Failure",
                                    Toast.LENGTH_SHORT).show();
                        }
                        String umrnNo = "";
                        String addDetails = checkout_res
                                .getMerchantResponsePayload().getMerchantAdditionalDetails();
                        if (addDetails.contains("UMRNNumber")) {
                            String[] arrMandateData = addDetails.split("mandateData\\{");
                            if (arrMandateData != null && arrMandateData.length > 1) {
                                String[] arrMandateParams = arrMandateData[1].split("~");
                                if (arrMandateParams != null
                                        && arrMandateParams.length > 1) {
                                    String[] arrUMRN = arrMandateParams[0].split(":");
                                    if (arrUMRN != null && arrUMRN.length > 1) {
                                        umrnNo = arrUMRN[1];
                                    }
                                }
                            }
                        }

                        String result = "StatusCode : " + checkout_res
                                .getMerchantResponsePayload().getPaymentMethod()
                                .getPaymentTransaction().getStatusCode()
                                + "\nStatusMessage : " + checkout_res
                                .getMerchantResponsePayload().getPaymentMethod()
                                .getPaymentTransaction().getStatusMessage()
                                + "\nErrorMessage : " + checkout_res
                                .getMerchantResponsePayload().getPaymentMethod()
                                .getPaymentTransaction().getErrorMessage()
                                + "\nAmount : " + checkout_res
                                .getMerchantResponsePayload().getPaymentMethod().getPaymentTransaction().getAmount()
                                + "\nDateTime : " + checkout_res.
                                getMerchantResponsePayload().getPaymentMethod()
                                .getPaymentTransaction().getDateTime()
                                + "\nMerchantTransactionIdentifier : "
                                + checkout_res.getMerchantResponsePayload()
                                .getMerchantTransactionIdentifier()
                                + "\nIdentifier : " + checkout_res
                                .getMerchantResponsePayload().getPaymentMethod()
                                .getPaymentTransaction().getIdentifier()
                                + "\nBankSelectionCode : " + checkout_res
                                .getMerchantResponsePayload().getPaymentMethod()
                                .getBankSelectionCode()
                                + "\nBankReferenceIdentifier : " + checkout_res
                                .getMerchantResponsePayload().getPaymentMethod()
                                .getPaymentTransaction().getBankReferenceIdentifier()
                                + "\nRefundIdentifier : " + checkout_res
                                .getMerchantResponsePayload().getPaymentMethod()
                                .getPaymentTransaction().getRefundIdentifier()
                                + "\nBalanceAmount : " + checkout_res
                                .getMerchantResponsePayload().getPaymentMethod()
                                .getPaymentTransaction().getBalanceAmount()
                                + "\nInstrumentAliasName : " + checkout_res
                                .getMerchantResponsePayload().getPaymentMethod()
                                .getInstrumentAliasName()
                                + "\nSI Mandate Id : " + checkout_res
                                .getMerchantResponsePayload().getPaymentMethod()
                                .getPaymentTransaction().getInstruction().getId()
                                + "\nUMRN No : "
                                + umrnNo

                                + "\nSI Mandate Status : " + checkout_res
                                .getMerchantResponsePayload().getPaymentMethod()
                                .getPaymentTransaction().getInstruction().getStatusCode()
                                + "\nSI Mandate Error Code : " + checkout_res
                                .getMerchantResponsePayload().getPaymentMethod()
                                .getPaymentTransaction().getInstruction().getErrorcode();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else if (resultCode == PaymentActivity.RESULT_ERROR) {
                Log.d(TAG, "got an error");
                if (data.hasExtra(PaymentActivity.RETURN_ERROR_CODE) &&
                        data.hasExtra(PaymentActivity.RETURN_ERROR_DESCRIPTION)) {
                    String error_code = (String) data
                            .getStringExtra(PaymentActivity.RETURN_ERROR_CODE);
                    String error_desc = (String) data
                            .getStringExtra(PaymentActivity.RETURN_ERROR_DESCRIPTION);
                    Toast.makeText(getApplicationContext(), " Got error :"
                            + error_code + "--- " + error_desc, Toast.LENGTH_SHORT)
                            .show();
                    Log.d(TAG + " Code=>", error_code);
                    Log.d(TAG + " Desc=>", error_desc);
                }
            } else if (resultCode == PaymentActivity.RESULT_CANCELED) {
                Toast.makeText(getApplicationContext(), "Transaction Aborted by User",
                        Toast.LENGTH_SHORT).show();
                Log.d(TAG, "User pressed back button");
            }
        }

        if (requestCode == REQUEST_CODE_PAYTM && data != null) {
            Toast.makeText(this, data.getStringExtra("nativeSdkForMerchantMessage") + data.getStringExtra("response"), Toast.LENGTH_SHORT).show();
        }

    }
}
