# Base ViewBinding

## Usage

### Activity

````kotlin
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
	setSupportActionBar(binding.toolbar)
    }

    ...
}
````


### Fragment

````kotlin
class ItemsFragment : BaseFragment<FragmentItemsBinding>(FragmentItemsBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.tvTitle = "Hello World!"
    }

    ...
}
````

### RecyclerView Adapter

````kotlin
class ItemsAdapter : BaseAdapter<ItemsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflateBinding(ItemItemBinding::inflate))
    }
	
    ...
	
    class ViewHolder(
        private val binding: ItemItemBinding
    ) : BaseViewHolder<ItemItemBinding>(binding) {

        fun bind(item: DummyItem) {
            binding.tvContent = item.content
        }

        ...

    }
}
````
