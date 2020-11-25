package com.example.password;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private EditText edtPassword;
    private TextView txtRange, txtMore, txtUpper, txtLower, txtSpecial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtPassword = findViewById(R.id.edtPassword);
        txtMore = findViewById(R.id.txtMore);
        txtUpper = findViewById(R.id.txtUpper);
        txtLower = findViewById(R.id.textLower);
        txtSpecial = findViewById(R.id.textSpecial);
        txtRange = findViewById(R.id.txtRange);
        edtPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                PasswordStrength(edtPassword.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    public void PasswordStrength(String password) {
        Pattern upperCase = Pattern.compile("[A-Z]");
        Pattern lowerCase = Pattern.compile("[a-z]");
        Pattern digit = Pattern.compile("[0-9]");
        Pattern special = Pattern.compile("[!\"#$%&'()*+,-./:;<=>?@^_`{|}~]");

        if (password.length() <= 6) {
            if (digit.matcher(password).find() && !lowerCase.matcher(password).find() && !upperCase.matcher(password).find()) {
                txtRange.setText("Weak");
                //txtRange.setTextColor(Color.RED);
                txtRange.setTextColor(getResources().getColor(R.color.Red));
                txtMore.setAlpha(1);
                txtSpecial.setAlpha(1);
                txtLower.setAlpha(1);
                txtUpper.setAlpha(1);
            } else if (digit.matcher(password).find() && lowerCase.matcher(password).find() && !upperCase.matcher(password).find()) {
                txtRange.setText("Weak");
                txtRange.setTextColor(getResources().getColor(R.color.Red));
                txtMore.setAlpha(1);
                txtSpecial.setAlpha(1);
                txtUpper.setAlpha(1);
                txtLower.setAlpha(0);
            } else if (digit.matcher(password).find() && upperCase.matcher(password).find() && !lowerCase.matcher(password).find()) {
                txtRange.setTextColor(getResources().getColor(R.color.Red));
                txtRange.setText("Weak");
                txtMore.setAlpha(1);
                txtSpecial.setAlpha(1);
                txtLower.setAlpha(1);
                txtUpper.setAlpha(0);
            } else if (digit.matcher(password).find() && lowerCase.matcher(password).find() && upperCase.matcher(password).find()) {
                txtRange.setTextColor(getResources().getColor(R.color.Red));
                txtRange.setText("Weak");
                txtMore.setAlpha(1);
                txtSpecial.setAlpha(1);
                txtLower.setAlpha(0);
                txtUpper.setAlpha(0);
            }
        } else if (password.length() > 6 && password.length() <= 12 && !special.matcher(password).find()) {
            if (digit.matcher(password).find() && !lowerCase.matcher(password).find() && !upperCase.matcher(password).find()) {
                txtRange.setText("Medium");
                txtRange.setTextColor(getResources().getColor(R.color.Red));
                txtSpecial.setAlpha(1);
                txtLower.setAlpha(1);
                txtUpper.setAlpha(1);
                txtMore.setAlpha(0);
            } else if (digit.matcher(password).find() && lowerCase.matcher(password).find() && !upperCase.matcher(password).find()) {
                txtRange.setText("Medium");
                txtRange.setTextColor(getResources().getColor(R.color.Yellow));
                txtSpecial.setAlpha(1);
                txtUpper.setAlpha(1);
                txtMore.setAlpha(0);
                txtLower.setAlpha(0);
            } else if (digit.matcher(password).find() && !upperCase.matcher(password).find() && !lowerCase.matcher(password).find()) {
                txtRange.setText("Medium");
                txtRange.setTextColor(getResources().getColor(R.color.Yellow));
                txtSpecial.setAlpha(1);
                txtLower.setAlpha(1);
                txtUpper.setAlpha(0);
                txtMore.setAlpha(0);
            } else if (digit.matcher(password).find() && upperCase.matcher(password).find() && lowerCase.matcher(password).find()) {
                txtRange.setText("Medium+");
                txtRange.setTextColor(getResources().getColor(R.color.Yellow));
                txtSpecial.setAlpha(1);
                txtLower.setAlpha(0);
                txtUpper.setAlpha(0);
                txtMore.setAlpha(0);
            }
        } else if (password.length() > 6 && password.length() <= 12 && special.matcher(password).find()) {
            if (digit.matcher(password).find() || lowerCase.matcher(password).find() || upperCase.matcher(password).find()) {
                if (digit.matcher(password).find() && !lowerCase.matcher(password).find() && !upperCase.matcher(password).find()) {
                    txtRange.setText("Medium");
                    txtRange.setTextColor(getResources().getColor(R.color.Red));
                    txtLower.setAlpha(1);
                    txtUpper.setAlpha(1);
                    txtSpecial.setAlpha(0);
                    txtMore.setAlpha(0);
                } else if (digit.matcher(password).find() && lowerCase.matcher(password).find() && !upperCase.matcher(password).find()) {
                    txtRange.setText("Medium+");
                    txtRange.setTextColor(getResources().getColor(R.color.Yellow));
                    txtUpper.setAlpha(1);
                    txtLower.setAlpha(0);
                    txtSpecial.setAlpha(0);
                    txtMore.setAlpha(0);
                } else if (digit.matcher(password).find() && upperCase.matcher(password).find() && !lowerCase.matcher(password).find()) {
                    txtRange.setText("Medium+");
                    txtRange.setTextColor(getResources().getColor(R.color.Yellow));
                    txtUpper.setAlpha(0);
                    txtLower.setAlpha(1);
                    txtSpecial.setAlpha(0);
                    txtMore.setAlpha(0);
                } else if (digit.matcher(password).find() && upperCase.matcher(password).find() && lowerCase.matcher(password).find()) {
                    txtRange.setText("Medium++");
                    txtRange.setTextColor(getResources().getColor(R.color.Yellow));
                    txtUpper.setAlpha(0);
                    txtLower.setAlpha(0);
                    txtMore.setAlpha(0);
                    txtSpecial.setAlpha(0);
                }
            }
        } else if (password.length() > 12 && !special.matcher(password).find()) {
            if (digit.matcher(password).find()) {
                if (upperCase.matcher(password).find() && lowerCase.matcher(password).find()) {
                    txtRange.setText("Stronger");
                    txtSpecial.setAlpha(1);
                    txtUpper.setAlpha(0);
                    txtLower.setAlpha(0);
                    txtMore.setAlpha(0);
                    txtRange.setTextColor(getResources().getColor(R.color.Green));
                } else if (upperCase.matcher(password).find() && !lowerCase.matcher(password).find()) {
                    txtRange.setText("Stronger+");
                    txtRange.setTextColor(getResources().getColor(R.color.Green));
                    txtLower.setAlpha(1);
                    txtSpecial.setAlpha(1);
                    txtUpper.setAlpha(0);
                    txtMore.setAlpha(0);
                } else if (lowerCase.matcher(password).find() && !upperCase.matcher(password).find()) {
                    txtRange.setText("Stronger+");
                    txtRange.setTextColor(getResources().getColor(R.color.Green));
                    txtUpper.setAlpha(1);
                    txtSpecial.setAlpha(1);
                    txtLower.setAlpha(0);
                    txtMore.setAlpha(0);
                }
            }
        } else if (password.length() > 12 && special.matcher(password).find()) {
            if (digit.matcher(password).find()) {
                if (upperCase.matcher(password).find() && lowerCase.matcher(password).find()) {
                    txtRange.setText("Stronger++");
                    txtRange.setTextColor(getResources().getColor(R.color.Green));
                    txtUpper.setAlpha(0);
                    txtLower.setAlpha(0);
                    txtMore.setAlpha(0);
                    txtSpecial.setAlpha(0);
                } else if (upperCase.matcher(password).find() && !lowerCase.matcher(password).find()) {
                    txtRange.setText("Stronger+");
                    txtRange.setTextColor(getResources().getColor(R.color.Green));
                    txtLower.setAlpha(1);
                    txtUpper.setAlpha(0);
                    txtMore.setAlpha(0);
                    txtSpecial.setAlpha(0);
                } else if (lowerCase.matcher(password).find() && !upperCase.matcher(password).find()) {
                    txtRange.setText("Stronger+");
                    txtRange.setTextColor(getResources().getColor(R.color.Green));
                    txtUpper.setAlpha(1);
                    txtLower.setAlpha(0);
                    txtMore.setAlpha(0);
                    txtSpecial.setAlpha(0);
                }
            }
        }
    }
}
