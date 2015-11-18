package craitsonmayer.com.br.aula1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.net.URI;


public class MainActivity extends Activity {

    private EditText nomeEditText;
    private TextView saudacaoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.nomeEditText = (EditText) findViewById(R.id.nomeEditText);
        this.saudacaoTextView = (TextView) findViewById(R.id.saudacaoTextView);
    }

    public void surpreenderUsuario(View v) {
        Editable texto = this.nomeEditText.getText();
        this.saudacaoTextView.setText(texto);
    }

    public void abrirUrl(View v) {
        Uri uri = Uri.parse("http://www.unidavi.edu.br");
        Intent  intent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }

    public void tirarFoto(View v) {
        Uri uri = Uri.fromFile(new File("/data/fotos/hello_camera.jpg"));
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        startActivity(intent);
    }


}
