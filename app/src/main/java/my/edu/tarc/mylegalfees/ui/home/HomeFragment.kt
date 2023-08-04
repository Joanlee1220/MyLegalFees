package my.edu.tarc.mylegalfees.ui.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import my.edu.tarc.mylegalfees.R
import my.edu.tarc.mylegalfees.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imageViewPhone.setOnClickListener {
            //Implicit Intent - a general action
            //Explicit Intent - specific component

            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("tel:0342567788"))
            startActivity(intent)
        }

        binding.buttonCalculate.setOnClickListener {
            val sellingPrice = binding.editTextSelling.text.toString().toFloat()
            val downPayment = binding.editTextDown.text.toString().toFloat()
            val loan = sellingPrice - downPayment
            val firstTime = binding.checkBoxFirstTime.isChecked
            if(firstTime){
                //Process first time buyer
                //loan can be <= 90% of the selling price
            }else{
                //Process non-first time buyer
                //loan must be more than 90% of the selling price
            }
        }
        binding.buttonReset.setOnClickListener {

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}