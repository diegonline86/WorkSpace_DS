package cronometro.tema01.psp.dam.salesianostriana.com.psp_cronometro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    Boolean pause;
    ExecutorService myES;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicializamos los elementos de la IU
        final EditText editTiempoTotal = (EditText) findViewById(R.id.editTiempoTotal);
        final Button btn_empezar = (Button) findViewById(R.id.btn_empezar);
        final Button btn_pause = (Button) findViewById(R.id.btnPause);
        final Button btn_resume = (Button) findViewById(R.id.btnResume);
        final TextView txtTiempoRestante = (TextView) findViewById(R.id.txtTiempoRestante);
        final EditText editRetardo = (EditText) findViewById(R.id.editTextRetardo);
        pause = false;

        //Asignamos al botón un manejador del envento click.
        btn_empezar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Completar el código aquí

                //Creamos un objeto ExecutorService y le asignamos un ThreadPool fijo de 1 hilo
                myES = Executors.newFixedThreadPool(1);
                //Invocamos la ejecucion del ExecutorService
                myES.execute(new Runnable() {
                    @Override
                    public synchronized void run() {
                        //Recuperamos el valor fijado por el usuario
                        double inicio = Double.valueOf(editTiempoTotal.getText().toString());
                        double retardo = Double.valueOf(editRetardo.getText().toString());
                        int sleep = Integer.valueOf(editRetardo.getText().toString());

                        for (double i = inicio; i > -1; i -= (retardo / 1000)) {
                            try {
                                if (i < 0) {
                                    i = 0;
                                    actualizarTiempo(txtTiempoRestante, i);
                                    i = -2;
                                } else {
                                    actualizarTiempo(txtTiempoRestante, i);
                                }
                                //con una espera de un segundo por cada iteración
                                Thread.sleep(sleep);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
                myES.shutdown();

            }
        });

        btn_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                try {
                    if(!pause) {
                        pause = true;
                        synchronized (myES) {
                            myES.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        btn_resume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                synchronized (myES){
                    if(pause) {
                        pause = false;
                        myES.notify();
                    }
                }
            }
        });

    }

    /*
        Este método sirve para actualizar el texto que aparece en pantalla
        y que refleja el número de segundos restantes que le quedan al cronómetro

        Hay que invocarlo pasandole como primer argumento la variable txtTiempoRestante
     */
    public void actualizarTiempo(final TextView txt, final double tiempoRestante) {
        txt.post(new Runnable() {
            @Override
            public void run() {
                txt.setText(String.format("%.1f",tiempoRestante) + " s.");
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
