package vcmsa.projects.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val edtAmount = findViewById<EditText>(R.id.editTextText)
        val edtTip = findViewById<EditText>(R.id.editTextText2)
        val btnCalculate = findViewById<Button>(R.id.btnCalc)
        var txtOut = findViewById<TextView>(R.id.edtHello)

        btnCalculate.setOnClickListener{
            val billAmountText = edtAmount.text.toString()
            val billAmount = billAmountText.toDouble()

            val tiptext = edtTip.text.toString()
            val tipAmount = tiptext.toDouble() / 100
            val tip = billAmount * tipAmount

            txtOut.text = "Tip amount: $${"%.2f".format(tip)}"
        }
    }
}