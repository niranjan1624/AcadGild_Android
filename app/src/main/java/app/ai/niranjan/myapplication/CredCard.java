package app.ai.niranjan.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class CredCard extends AppCompatActivity {
    EditText bal, interest, minPayment,finalCardBal, months, paidInt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.credit);

        bal = (EditText) findViewById(R.id.bal);
        interest = (EditText) findViewById(R.id.interest);
        minPayment = (EditText)findViewById(R.id.minPayment);
        finalCardBal = (EditText) findViewById(R.id.cardBal);
        months = (EditText) findViewById(R.id.months);
        paidInt = (EditText) findViewById(R.id.paidInt);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cred_card, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void clear(View view) {
        ViewGroup group = (ViewGroup)findViewById(R.id.layout1);
        for (int i = 0, count = group.getChildCount(); i < count; ++i) {
            View v = group.getChildAt(i);
            if (v instanceof EditText) {
                ((EditText)v).setText("");
            }
        }
    }

    public void compute(View view) {
        String bal1, interest1, minPay;
        bal1 = bal.getText().toString();
        interest1 = interest.getText().toString();
        minPay = minPayment.getText().toString();

            int principal  = Integer.parseInt(bal1), rate = Integer.parseInt(interest1), iMinPay = Integer.parseInt(minPay);
            int monthlyFloatInterestPaid, monthlyPrincipal, monthlyBal, monthsRemain;
            finalCardBal = (EditText) findViewById(R.id.cardBal);

            int count = 0;
            while(principal > 0) {
                monthlyFloatInterestPaid = Math.round((principal * (rate/(100 * 12))));
                monthlyPrincipal = iMinPay - monthlyFloatInterestPaid;
                monthlyBal = principal - monthlyPrincipal;
                if(count == 0) {
                    finalCardBal.setText(monthlyBal + "");
                    paidInt.setText(monthlyFloatInterestPaid + "");
                }
                principal = monthlyBal;

                count++;
            }
            months.setText((count - 1) + "");
        
    }
}
