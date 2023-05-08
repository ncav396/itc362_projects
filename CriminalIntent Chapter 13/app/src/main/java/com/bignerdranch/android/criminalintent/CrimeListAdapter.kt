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
import java.util.UUID

//Add view types as immutable constants
private const val ViewType = 0

class CrimeHolder (
    private val binding: ListItemCrimeBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(crime: Crime, onCrimeClicked: (crimeId: UUID) -> Unit) {
            binding.crimeTitle.text = crime.title
            binding.crimeDate.text =  DateFormat.getDateInstance().format(crime.date).toString()

            binding.root.setOnClickListener {
              onCrimeClicked(crime.id)
            }

            binding.crimeSolved.visibility = if (crime.isSolved) {
                View.VISIBLE
            } else {
                View.GONE
            }
        }
}

class CrimeListAdapter(
    private val crimes: List<Crime>,
    private val onCrimeClicked: (crimeId: UUID) -> Unit
) : RecyclerView.Adapter<CrimeHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) : CrimeHolder{
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

    override fun onBindViewHolder(holder: CrimeHolder, position: Int) {
        val crime = crimes[position]
       holder.bind(crime, onCrimeClicked)
    }

    override fun getItemCount() = crimes.size
}