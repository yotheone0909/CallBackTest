package splanet.com.callbacktest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Dev02 on 10/31/2017.
 */

public class OptionDialog extends DialogFragment {

    private OnSelectListener onSelectListener = null;

    private Button boxEdit = null;
    private Button boxDelete = null;
    private Button boxCancel = null;

    public void setOnSelectListener(OnSelectListener onSelectListener) {
        this.onSelectListener = onSelectListener;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NORMAL, android.R.style.Theme_Translucent_NoTitleBar);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_options, container, false);

        boxEdit = (Button) view.findViewById(R.id.boxEdit);
        boxDelete = (Button) view.findViewById(R.id.boxDelete);
        boxCancel = (Button) view.findViewById(R.id.boxCancel);

        boxEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (onSelectListener != null) {
                    onSelectListener.onEdit("EditSuccess");
                }
                dismiss();

            }
        });

        boxDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                OptionDialogConfigDelete optionDialogConfigDelete = new OptionDialogConfigDelete();
                optionDialogConfigDelete.show(getFragmentManager(),
                        OptionDialogConfigDelete.class.getSimpleName());
                optionDialogConfigDelete.setOnSelectConfigDelete(new OnSelectConfigDeleteListener() {
                    @Override
                    public void onDelete() {
                        if (onSelectListener != null) {
                            onSelectListener.onDelete("DeleteSuccess");
                        }
                        dismiss();
                    }

                    @Override
                    public void onCancel() {
                        if (onSelectListener != null) {
                            onSelectListener.onCancel("Cancel");
                        }
                        dismiss();
                    }
                });


            }
        });

        boxCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (onSelectListener != null) {
                    onSelectListener.onCancel("CancelSuccess");
                }
                dismiss();
            }
        });

        return view;
    }
}
