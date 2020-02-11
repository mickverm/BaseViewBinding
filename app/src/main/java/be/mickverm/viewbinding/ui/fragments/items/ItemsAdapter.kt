package be.mickverm.viewbinding.ui.fragments.items

import android.view.ViewGroup
import be.mickverm.viewbinding.data.dummy.DummyContent.DummyItem
import be.mickverm.viewbinding.databinding.ItemDummyItemBinding
import be.mickverm.viewbinding.ui.base.BaseAdapter

class ItemsAdapter(
    private val values: List<DummyItem>
) : BaseAdapter<ItemsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflateBinding(ItemDummyItemBinding::inflate))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(values[position])
    }

    override fun getItemCount(): Int = values.size

    class ViewHolder(private val binding: ItemDummyItemBinding) : BaseViewHolder(binding) {

        fun bind(item: DummyItem) {
            binding.itemNumber.text = item.id
            binding.content.text = item.content
        }
    }
}
