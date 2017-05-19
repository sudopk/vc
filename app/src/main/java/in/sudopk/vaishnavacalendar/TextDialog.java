package in.sudopk.vaishnavacalendar;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.Method;

import in.sudopk.utils.StrUtil;

public class TextDialog extends AppCompatDialogFragment {
    private static final String TITLE = "title";
    private static final String MESSAGE = "message";
    private static final String BUTTONS = "buttons";

    public static TextDialog newBlockingInstance(String message, ButtonDescription[] buttons) {
        return new Builder(message, buttons).setCancelable(false).build();
    }

    public static TextDialog newCancelableInstance(String message, ButtonDescription[] buttons) {
        return new Builder(message, buttons).setCancelable(true).build();
    }

    private void onButton(ButtonDescription button) {
        dismiss();
        onButtonClicked(button.getId());
    }

    private void onButtonClicked(final String buttonId) {
        getContainer().onDialogButtonClicked(buttonId);
    }

    private Container getContainer() {
        if (getParentFragment() != null) {
            return (Container) getParentFragment();
        }
        return (Container) getActivity();
    }

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(StrUtil.isNotEmpty(getArguments().getString(TITLE))) {
            setStyle(DialogFragment.STYLE_NORMAL, R.style.Theme_AppCompat_Light_Dialog);
        } else {
            setStyle(DialogFragment.STYLE_NO_TITLE, 0);
        }
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container,
                             @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.text_dialog, container, false);
        ((TextView) view.findViewById(R.id.message)).setText(getArguments().getString(MESSAGE));
        LinearLayout buttons = (LinearLayout) view.findViewById(R.id.buttons);
        buttons.removeAllViews();
        //noinspection ConstantConditions
        for (Parcelable button : getArguments().getParcelableArray(BUTTONS)) {
            addButton(inflater, buttons, (ButtonDescription) button);
        }
        return view;
    }

    @Override
    @NonNull
    public Dialog onCreateDialog(final Bundle savedInstanceState) {
        final Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.setTitle(getArguments().getString(TITLE));
        return dialog;
    }

    private void addButton(LayoutInflater inflater, ViewGroup parent, ButtonDescription
            buttonDescription) {
        Button button = (Button) inflater.inflate(R.layout.borderless_button, parent, false);
        button.setOnClickListener(v -> {
            onButton(buttonDescription);
        });
        button.setText(buttonDescription.getTitle());
        parent.addView(button);
    }

    public static final class Builder {
        private final String mMessage;
        private final ButtonDescription[] mButtons;
        private boolean mCancelable;
        private String mTitle;

        public Builder(String message, ButtonDescription[] buttons) {
            mMessage = message;
            mButtons = buttons;
            mCancelable = false;
            mTitle = "";
        }

        public Builder setCancelable(boolean cancelable) {
            mCancelable = cancelable;
            return this;
        }

        public Builder setTitle(String title) {
            mTitle = title;
            return this;
        }

        public TextDialog build() {
            Bundle args = new Bundle();
            args.putString(TITLE, mTitle);
            args.putString(MESSAGE, mMessage);
            args.putParcelableArray(BUTTONS, mButtons);

            TextDialog fragment = new TextDialog();
            fragment.setArguments(args);
            fragment.setCancelable(mCancelable);
            return fragment;
        }
    }

    @Override
    public void onCancel(final DialogInterface dialog) {
        super.onCancel(dialog);
        getContainer().onDialogCanceled();
    }

    public interface Container {
        void onDialogButtonClicked(String buttonId);

        void onDialogCanceled();
    }
}
