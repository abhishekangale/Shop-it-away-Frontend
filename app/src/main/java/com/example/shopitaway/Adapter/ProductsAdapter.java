package com.example.shopitaway.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.shopitaway.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.bumptech.glide.Glide;
import com.example.shopitaway.Model.Product;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductHolder>{

    List<Product> productList;
    OnClickedProducct interfaceclickedonProduct;

    public ProductsAdapter(OnClickedProducct interfaceclickedonProduct) {
        this.interfaceclickedonProduct = interfaceclickedonProduct;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.productstyleslist, parent, false);
        return  new ProductHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductHolder holder, int position) {
        holder.titeofproduct.setText(productList.get(position).getName());
        holder.descriptionofproduct.setText(productList.get(position).getDescription());

        Glide.with(holder.itemView.getContext()).load(productList.get(position).getImage()).centerCrop().into(holder.circleImageView);

    }

    @Override
    public int getItemCount() {
        if (productList == null) {

            return 0;

        } else {

            return productList.size();
        }
    }

    class ProductHolder extends ViewHolder implements View.OnClickListener{

        TextView titeofproduct, descriptionofproduct;
        CircleImageView circleImageView;

        public ProductHolder(@NonNull View itemView) {
            super(itemView);

            titeofproduct = itemView.findViewById(R.id.proudcttitlte);
            descriptionofproduct = itemView.findViewById(R.id.productdescriptionmain);
            circleImageView = itemView.findViewById(R.id.productmainiamge);


            titeofproduct.setOnClickListener(this);
            descriptionofproduct.setOnClickListener(this);
            circleImageView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            interfaceclickedonProduct.OnProClicked(productList, getAdapterPosition());
        }
    }

    public interface OnClickedProducct{
        void OnProClicked(List<Product> productList, int position);

    }
}
