package zimmermann.larissa.elderlylife.recycler;

import android.view.View;

/**
 * Created by gms19 on 14/08/2017.
 */

public interface ClickListener{
    void onClick(View view, int position);

    void onLongClick(View view, int position);
}

