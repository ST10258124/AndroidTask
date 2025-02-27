package vcmsa.projects.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
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
        val txtOut = findViewById<TextView>(R.id.edtHello)
        val edtMembers = findViewById<TextView>(R.id.edtNumMembers)
        val chkSplitBill = findViewById<CheckBox>(R.id.chkSplit)


        btnCalculate.setOnClickListener{
            val billAmountText = edtAmount.text.toString()
            val billAmount = billAmountText.toDouble()

            val tiptext = edtTip.text.toString()
            val tipAmount = tiptext.toDouble() / 100
            val tip = billAmount * tipAmount



            if (chkSplitBill.isChecked){
                val members = edtMembers.text.toString().toInt()
                val splitAmount = (billAmount + tip) / members
                txtOut.text = "Tip amount: $${"%.2f".format(tip)}\nEach member pays: \$${"%.2f".format(splitAmount)}"
            } else{
                txtOut.text = "Tip amount: $${"%.2f".format(tip)}"
            }
        }
    }
}