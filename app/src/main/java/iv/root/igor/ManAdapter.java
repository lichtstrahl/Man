package iv.root.igor;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ManAdapter extends RecyclerView.Adapter<ManAdapter.ViewHolder> {
    List<Man> list;
    LayoutInflater inflater;

    ManAdapter(List<Man> l, LayoutInflater i) {
        list = l;
        inflater = i;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(inflater.inflate(R.layout.layout_list_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bindMan(i);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void append(Man man) {
        list.add(man);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView fName;
        TextView lName;
        ImageView avatar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            fName = itemView.findViewById(R.id.viewName);
            lName = itemView.findViewById(R.id.viewLastName);
            avatar = itemView.findViewById(R.id.viewAvatar);
        }

        void bindMan(int index) {
            Man man = list.get(index);
            fName.setText(man.getFirstName());
            lName.setText(man.getLastName());
            GlideApp.with(avatar.getContext()).load(man.getPicture().getUrl()).into(avatar);
        }
    }
}
