package com.scoop.scoopiio;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText boltonInput; //Reference to the interface
    TextView boltonText; //Reference to the interface, here comes the output
    Database database; // Reference to the interface

    @Override
    protected void onCreate(Bundle savedInstanceState) { /** **/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // reference to the layout I want to display
        boltonInput = (EditText) findViewById(R.id.BoltonInput); //reference to input I named xml splash file
        boltonText = (TextView) findViewById(R.id.andysText); // reference to the textfield in the xml file
        database = new Database(this, null,null, 1);
        printDatabase();
    }
    // Add to database
    public void addButtonClicked(View view){
        Products product = new Products(boltonInput.getText().toString());
        database.addProduct(product);
        printDatabase();
    }
    //This will delete items I have putted in
    public void deleteButtonClicked(View view){
        String InputText = boltonInput.getText().toString();
        database.deleteProduct(InputText);
        printDatabase(); //print database on the screen

    }

    public void printDatabase(){
        String dbString = database.databaseToString();
        boltonText.setText(dbString);
        boltonInput.setText("");
    }

}


