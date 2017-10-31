package splanet.com.callbacktest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Dev02 on 10/31/2017.
 */

public class OptionDialogConfigDelete extends DialogFragment {

private OnSelectConfigDeleteListener onSelectConfigDeleteListener = null;
    private Button boxYes = null;
    private Button boxCancel = null;

    public void setOnSelectConfigDelete(OnSelectConfigDeleteListener onSelectConfigDelete) {
        onSelectConfigDeleteListener = onSelectConfigDelete;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_config_delete,container,false);

        boxYes = (Button) view.findViewById(R.id.boxYes);
        boxCancel = (Button) view.findViewById(R.id.boxCancel);

        boxYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (onSelectConfigDeleteListener != null) {
                    onSelectConfigDeleteListener.onDelete();
                }
                dismiss();

            }
        });

        boxCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onSelectConfigDeleteListener != null) {
                    onSelectConfigDeleteListener.onCancel();
                }
                dismiss();
            }
        });

        return view;
    }
}
