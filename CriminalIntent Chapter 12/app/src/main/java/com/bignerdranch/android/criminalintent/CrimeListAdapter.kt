package com.bignerdranch.android.criminalintent
import android.icu.text.DateFormat
import android.icu.text.SimpleDateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.criminalintent.databinding.ListItemCrimeBinding
import com.bignerdranch.android.criminalintent.databinding.ListItemCrimePoliceBinding

//Add view types as immutable constants
private const val ViewType = 0
private const val ViewTypePolice = 1

class CrimeHolder (
    private val binding: ListItemCrimeBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(crime: Crime) {
            binding.crimeTitle.text = crime.title
            binding.crimeDate.text =  DateFormat.getDateInstance().format(crime.date).toString()

            binding.root.setOnClickListener {
                Toast.makeText(
                    binding.root.context,
                    "${crime.title} clicked!",
                    Toast.LENGTH_SHORT
                ).show()
            }

            binding.crimeSolved.visibility = if (crime.isSolved) {
                View.VISIBLE
            } else {
                View.GONE
            }
        }
}

class PoliceHolder (
    private val binding: ListItemCrimePoliceBinding
    ) : RecyclerView.ViewHolder(binding.root) {
    fun bind(crime: Crime) {
        binding.crimeTitle.text = crime.title
        binding.crimeDate.text =  DateFormat.getDateInstance().format(crime.date).toString()

        binding.root.setOnClickListener {
            Toast.makeText(
                binding.root.context,
                "${crime.title} clicked!",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.contactPoliceButton.setOnClickListener {
            Toast.makeText(
                binding.root.context,
                // Make the entire toast capitalized to emphasize intensity
                "POLICE CONTACTED REGARDING ${crime.title.uppercase()}!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}


class CrimeListAdapter(
    private val crimes: List<Crime>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) : RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = when (viewType) {
            ViewType -> ListItemCrimeBinding.inflate(inflater, parent, false)
            else -> throw IllegalArgumentException("Invalid view type!")
        }
        return when (viewType) {
            ViewType -> CrimeHolder(binding as ListItemCrimeBinding)
            else -> throw IllegalArgumentException("Invalid view type!")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val crime = crimes[position]
        when (holder) {
            is CrimeHolder -> holder.bind(crime)
            else -> throw IllegalArgumentException("Invalid ViewHolder type")
        }
    }

    override fun getItemCount() = crimes.size
}