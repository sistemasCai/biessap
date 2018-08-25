package com.biessap.biessap.Activitys.OrientacionUniversitaria;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.biessap.biessap.R;

public class ActivityOrientacion extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orientacion);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Atras");

        Button btnVer = findViewById(R.id.btnVer);
        btnVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActivityOrientacion.this,AreasActivity.class);
                startActivity(i);
            }
        });

        TextView textView = findViewById(R.id.textView3);
        String html = "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<FONT COLOR=\"#323e4f\"><FONT FACE=\"Helvetica Neue, serif\"><FONT SIZE=4 STYLE=\"font-size: 16pt\"><B>CONCEPTOS\n" +
                "Y TERMINOS BASICOS </B></FONT></FONT></FONT>\n" +
                "</P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<BR>\n" +
                "</P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<FONT COLOR=\"#3b3838\"><FONT FACE=\"Helvetica Neue, serif\">Una vez ya\n" +
                "elegida la carrera profesional que estudiaremos, nos topamos con\n" +
                "términos básicos el primer dia de inscripcion, primer dia de clases\n" +
                "o simplemente mucho mas antes de elegir la profesion, que muy pocas\n" +
                "personas conocen, como ¿qué es una matrícula?, un semestre, una\n" +
                "carrera anual y sus importancias, al igual la diferencia de una\n" +
                "profesión a nivel licienciatura , técnico medio, superior y entre\n" +
                "otros.</FONT></FONT></P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<FONT COLOR=\"#3b3838\"><FONT FACE=\"Helvetica Neue, serif\">En esta\n" +
                "pestaña te guiaremos paso a paso los detalles e importancias de cada\n" +
                "una de ellos. </FONT></FONT>\n" +
                "</P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<BR>\n" +
                "</P>";
        textView.setText(Html.fromHtml(html));

        String matriculas = "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<FONT COLOR=\"#2e74b5\"><FONT FACE=\"Helvetica Neue, serif\"><I><U><B>La \n" +
                "Matrícula</B></U></I></FONT></FONT></P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<BR>\n" +
                "</P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<FONT COLOR=\"#3b3838\"><SPAN STYLE=\"background: #ffffff\"> <FONT FACE=\"Helvetica Neue, serif\">El\n" +
                "proceso de&nbsp;</SPAN></FONT></FONT><FONT COLOR=\"#3b3838\"><FONT FACE=\"Helvetica Neue, serif\"><SPAN STYLE=\"background: #ffffff\">matrícula</SPAN></FONT></FONT><FONT COLOR=\"#3b3838\"><FONT FACE=\"Helvetica Neue, serif\"><SPAN STYLE=\"background: #ffffff\">&nbsp;es\n" +
                "el conjunto de políticas, procedimientos y actividades, </SPAN></FONT></FONT><FONT COLOR=\"#3b3838\"><FONT FACE=\"Helvetica Neue, serif\"><U><SPAN STYLE=\"background: #ffffff\">que\n" +
                "permiten organizar la continuidad de los alumnos antiguos y el\n" +
                "ingreso de alumnos nuevos.</SPAN></U></FONT></FONT></P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<BR>\n" +
                "</P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<FONT COLOR=\"#3b3838\"><FONT FACE=\"Helvetica Neue, serif\"><SPAN STYLE=\"background: #ffffff\">El\n" +
                "precio por matricularse a una institución varían de acuerdo a  las\n" +
                "políticas de cada universidad o institutos</SPAN></FONT></FONT></P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<BR>\n" +
                "</P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<FONT COLOR=\"#3b3838\"><FONT FACE=\"Helvetica Neue, serif\"><SPAN STYLE=\"background: #ffffff\">El\n" +
                "pago de la </SPAN></FONT></FONT><FONT COLOR=\"#3b3838\"><FONT FACE=\"Helvetica Neue, serif\"><I><SPAN STYLE=\"background: #ffffff\">matrícula</SPAN></I></FONT></FONT><FONT COLOR=\"#3b3838\"><FONT FACE=\"Helvetica Neue, serif\"><SPAN STYLE=\"background: #ffffff\">\n" +
                "es por única vez, hasta la conclusión de la carrera profesional\n" +
                "elegida. En algunas instituciones el pago es fraccionado, es decir en\n" +
                "2 u 3 pagos, de acuerdo a las políticas de cada institución.</SPAN></FONT></FONT></P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<BR>\n" +
                "</P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<BR>\n" +
                "</P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">";

        textView.append(Html.fromHtml(matriculas));

        String carrerasSemestrales = "<FONT COLOR=\"#2e74b5\"><FONT FACE=\"Helvetica Neue, serif\"><I><U><B><SPAN STYLE=\"background: #ffffff\">Carreras\n" +
                "semestrales </SPAN></B></U></I></FONT></FONT>\n" +
                "</P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<BR>\n" +
                "</P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<FONT COLOR=\"#3b3838\"><FONT FACE=\"Helvetica Neue, serif\"><SPAN STYLE=\"background: #ffffff\">Un\n" +
                "Semestre dentro la las instituciones educativas, es conocido como el\n" +
                "período de tiempo que tiene las materias o cursos dictados. Dentro\n" +
                "las universidades, es conocidos en dos periodos anuales y\n" +
                "semestrales. </SPAN></FONT></FONT>\n" +
                "</P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<BR>\n" +
                "</P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<FONT COLOR=\"#3b3838\"><FONT FACE=\"Helvetica Neue, serif\"><SPAN STYLE=\"background: #ffffff\">Las\n" +
                " semestrales tienen un período entre 16 y 20 semanas; llevando así\n" +
                "2 semestres  en 1 año.</SPAN></FONT></FONT></P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<BR>\n" +
                "</P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<FONT COLOR=\"#3b3838\"><FONT FACE=\"Helvetica Neue, serif\"><SPAN STYLE=\"background: #ffffff\">Dentro\n" +
                "del semestre se pueden llevar un máximo de 7 materias.</SPAN></FONT></FONT></P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<BR>\n" +
                "</P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<BR>\n" +
                "</P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" STYLE=\"margin-bottom: 0in\"><FONT COLOR=\"#2e74b5\"><FONT FACE=\"Helvetica Neue, serif\"><I><U><B><SPAN STYLE=\"background: #ffffff\">Carreras\n" +
                "Anuales</SPAN></B></U></I></FONT></FONT></P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<BR>\n" +
                "</P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<FONT COLOR=\"#3b3838\"><FONT FACE=\"Helvetica Neue, serif\"><SPAN STYLE=\"background: #ffffff\">Son\n" +
                "aquellas carreras que que concluyen su período dentro 1 año de\n" +
                "estudio.</SPAN></FONT></FONT></P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<BR>\n" +
                "</P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<FONT COLOR=\"#3b3838\"><FONT FACE=\"Helvetica Neue, serif\"><SPAN STYLE=\"background: #ffffff\">En\n" +
                "las carreras anuales se llevan un máximo 3 materias por cada mes.</SPAN></FONT></FONT></P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<BR>\n" +
                "</P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<FONT COLOR=\"#3b3838\"><FONT FACE=\"Helvetica Neue, serif\"><SPAN STYLE=\"background: #ffffff\">En\n" +
                "algunas universidades una misma carrera profesional pueden estar\n" +
                "semestral y en otra universidad anual.</SPAN></FONT></FONT></P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<FONT COLOR=\"#3b3838\"><FONT FACE=\"Helvetica Neue, serif\"><SPAN STYLE=\"background: #ffffff\">Es\n" +
                "muy importante elegir antes de estudiar una carrera profesional\n" +
                "dependiendo a la área profesional que té formaras este dos períodos\n" +
                "Semestral y Anual°</SPAN></FONT></FONT></P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<BR>\n" +
                "</P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<BR>\n" +
                "</P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n";

        textView.append(Html.fromHtml(carrerasSemestrales));
        String carrerasSemipre = "<FONT COLOR=\"#2e74b5\"><FONT FACE=\"Helvetica Neue, serif\"><FONT SIZE=3 STYLE=\"font-size: 12pt\"><I><U><B><SPAN STYLE=\"background: #ffffff\">Carreras\n" +
                "Semipresenciales</SPAN></B></U></I></FONT></FONT></FONT></P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<BR>\n" +
                "</P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<FONT COLOR=\"#3b3838\"><FONT FACE=\"Helvetica Neue, serif\"><FONT SIZE=3 STYLE=\"font-size: 11pt\"><SPAN STYLE=\"background: #ffffff\">Esta\n" +
                "modalidad empleadas en algunas universidades, consiste en asistir a\n" +
                "clases al menos una vez por semana, ya sea en el horario de la noche\n" +
                "o los fines de semana, es decir sábado o domingo.&nbsp;</SPAN></FONT></FONT></FONT><FONT COLOR=\"#3b3838\"><FONT FACE=\"Helvetica Neue, serif\"><FONT SIZE=3 STYLE=\"font-size: 11pt\"><BR>El\n" +
                "alumno </FONT></FONT></FONT><FONT COLOR=\"#3b3838\"><FONT FACE=\"Helvetica Neue, serif\"><FONT SIZE=3 STYLE=\"font-size: 11pt\"><SPAN STYLE=\"background: #ffffff\">\n" +
                "puede tomar hasta seis materias y avanzarlas en su casa mediante una\n" +
                "plataforma virtual, (online). Lo que se hace en cada clase es\n" +
                "reforzar el material que el universitario tiene en la plataforma.</SPAN></FONT></FONT></FONT></P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<BR>\n" +
                "</P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<FONT COLOR=\"#3b3838\"><FONT FACE=\"Helvetica Neue, serif\"><FONT SIZE=3 STYLE=\"font-size: 11pt\"><SPAN STYLE=\"background: #ffffff\">Para\n" +
                "todas las materias es necesario que el estudiante esté presente para\n" +
                "rendir los&nbsp;exámenes.</SPAN></FONT></FONT></FONT></P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<FONT COLOR=\"#3b3838\"><FONT FACE=\"Helvetica Neue, serif\"><FONT SIZE=3 STYLE=\"font-size: 11pt\"><SPAN STYLE=\"background: #ffffff\">Esta\n" +
                "Modalidad ayuda mucho a las personas que trabajan y/ó tienen otras\n" +
                "ocupaciones.</SPAN></FONT></FONT></FONT></P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<BR>\n" +
                "</P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<BR>\n" +
                "</P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<FONT COLOR=\"#2e74b5\"><FONT FACE=\"Helvetica Neue, serif\"><I><U><B><SPAN STYLE=\"background: #ffffff\">Carreras\n" +
                "Virtuales</SPAN></B></U></I></FONT></FONT></P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<BR>\n" +
                "</P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<FONT COLOR=\"#3b3838\"><FONT FACE=\"Helvetica Neue, serif\"><SPAN STYLE=\"background: #ffffff\">También\n" +
                "conocidos como ºCarreras a Distanciasº, Son aquellas profesiones\n" +
                "que se pueden estudiar desde cualquier lugar,</SPAN></FONT></FONT><FONT COLOR=\"#3b3838\"><FONT FACE=\"Helvetica Neue, serif\"><FONT SIZE=4 STYLE=\"font-size: 13pt\"><SPAN STYLE=\"background: #ffffff\">\n" +
                "</SPAN></FONT></FONT></FONT><FONT COLOR=\"#3b3838\"><FONT FACE=\"Helvetica Neue, serif\"><SPAN STYLE=\"background: #ffffff\">sin\n" +
                "la necesidad de asistir a clases en las aulas, sino directamente se\n" +
                "inscribirán y desde sus casas o desde sus comunidades, donde tengan\n" +
                "acceso a internet.</SPAN></FONT></FONT></P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<BR>\n" +
                "</P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<BR>\n" +
                "</P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<FONT COLOR=\"#2e74b5\"><FONT FACE=\"Helvetica Neue, serif\"><I><U><B>¿Qué\n" +
                "es una carrera profesional a Nivel Licenciatura?</B></U></I></FONT></FONT></P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<BR>\n" +
                "</P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<FONT COLOR=\"#3b3838\"><FONT FACE=\"Helvetica Neue, serif\"><SPAN STYLE=\"background: #ffffff\">Una\n" +
                "carrera a nivel Licenciatura</SPAN></FONT></FONT><FONT COLOR=\"#3b3838\"><FONT FACE=\"Helvetica Neue, serif\"><SPAN STYLE=\"background: #ffffff\">&nbsp;es\n" +
                "la condición que alcanza alguien que consigue una licencia. El\n" +
                "término se utiliza, por lo tanto, para describir a la&nbsp;</SPAN></FONT></FONT><FONT COLOR=\"#3b3838\"><FONT FACE=\"Helvetica Neue, serif\"><SPAN STYLE=\"background: #ffffff\">persona</SPAN></FONT></FONT><FONT COLOR=\"#3b3838\"><FONT FACE=\"Helvetica Neue, serif\"><SPAN STYLE=\"background: #ffffff\">&nbsp;que\n" +
                "completó una licenciatura, un título de carácter universitario al\n" +
                "que se accede después de cursar una carrera de entre cuatro y seis\n" +
                "años de duración. Las carreras de nivel Licenciatura lo encontramos\n" +
                "en las universidades.</SPAN></FONT></FONT></P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<FONT COLOR=\"#3b3838\"><FONT FACE=\"Helvetica Neue, serif\"><SPAN STYLE=\"background: #ffffff\">Ejemplo:\n" +
                "Medicina, Ing. Petrolera, Arquitectura, etc.</SPAN></FONT></FONT></P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<BR>\n" +
                "</P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<BR>\n" +
                "</P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">";
        textView.append(Html.fromHtml(carrerasSemipre));

        String carreraTecnicoSup = "<FONT COLOR=\"#2e74b5\"><FONT FACE=\"Helvetica Neue, serif\"><I><U><B><SPAN STYLE=\"background: #ffffff\">¿Qué\n" +
                "es una carrera profesional a nivel Técnico Superior?</SPAN></B></U></I></FONT></FONT></P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<BR>\n" +
                "</P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<FONT COLOR=\"#3b3838\"><FONT FACE=\"Helvetica Neue, serif\"><SPAN STYLE=\"background: #ffffff\">La\n" +
                "Educación Técnica está orientada a entregar a los estudiantes la\n" +
                "capacidad y los conocimientos necesarios para desempeñarse en una\n" +
                "especialidad de apoyo al nivel profesional, o bien desempeñarse por\n" +
                "cuenta propia.</SPAN></FONT></FONT></P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<BR>\n" +
                "</P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<FONT COLOR=\"#3b3838\"><FONT FACE=\"Helvetica Neue, serif\"><SPAN STYLE=\"background: #ffffff\">Las\n" +
                "carreras Técnicas de Nivel Superior se pueden impartir en\n" +
                "universidades, Institutos Profesiones (IP) y Centros de Formación\n" +
                "Técnica (CFT).</SPAN></FONT></FONT></P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<BR>\n" +
                "</P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<FONT COLOR=\"#3b3838\"><SPAN STYLE=\"background: #ffffff\">• <FONT FACE=\"Helvetica Neue, serif\">Para\n" +
                "obtener el título de técnico de nivel superior es necesario aprobar\n" +
                "un programa de estudios de una duración mínima de 1.600 horas de\n" +
                "clases (4 semestres).</SPAN></FONT></FONT></P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<FONT COLOR=\"#3b3838\"><SPAN STYLE=\"background: #ffffff\">• <FONT FACE=\"Helvetica Neue, serif\">La\n" +
                "mayoría de las carreras técnicas duran entre 4 semestres (2 años)\n" +
                "y 6 semestres (3 años).</SPAN></FONT></FONT></P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<BR>\n" +
                "</P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<FONT COLOR=\"#3b3838\"><FONT FACE=\"Helvetica Neue, serif\"><SPAN STYLE=\"background: #ffffff\">Ejemplo:\n" +
                "Electrónica, Ing. en Metalúrgica, Mecánica General, etc.</SPAN></FONT></FONT></P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<BR>\n" +
                "</P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<BR>\n" +
                "</P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<FONT COLOR=\"#2e74b5\"><FONT FACE=\"Helvetica Neue, serif\"><I><U><B><SPAN STYLE=\"background: #ffffff\">¿Qué\n" +
                "es estudio a nivel Técnico Medio?</SPAN></B></U></I></FONT></FONT></P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<BR>\n" +
                "</P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<FONT COLOR=\"#000000\"><FONT FACE=\"Helvetica Neue, serif\"><SPAN STYLE=\"background: #ffffff\">A\n" +
                "diferencia del Nivel Licenciatura y Técnico Superior, que exigen el\n" +
                "titulo del bachiller de Provisión Nacional al momento de\n" +
                "inscribirse, las  de Nivel Técnico Medio no lo hace, ya que son\n" +
                "cursos de preparatorias para una área profesional, que pueden cursar\n" +
                "estos estudios personas desde los 16 años de edad.</SPAN></FONT></FONT></P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<FONT COLOR=\"#000000\"><FONT FACE=\"Helvetica Neue, serif\"><SPAN STYLE=\"background: #ffffff\">Muchas\n" +
                "personas entran a esta área de estudio para levantar un negocio o\n" +
                "perfeccionarse en un rubro que ejercen o anhelan hacerlo.</SPAN></FONT></FONT></P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<BR>\n" +
                "</P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<FONT COLOR=\"#000000\"><FONT FACE=\"Helvetica Neue, serif\"><SPAN STYLE=\"background: #ffffff\">En\n" +
                "su mayoría de los estudios de Técnico Medio tiene una duración de\n" +
                "3 a 8 meses dependiendo el estudio a escoger.</SPAN></FONT></FONT></P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" STYLE=\"margin-bottom: 0in\"><FONT COLOR=\"#000000\"><FONT FACE=\"Helvetica Neue, serif\"><SPAN STYLE=\"background: #ffffff\">Ejemplo:\n" +
                "  Auxiliar Contable, Programador en Android, Pastelería y\n" +
                "Repostería, Curso de diseños Gráfico, etc.</SPAN></FONT></FONT></P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" STYLE=\"margin-bottom: 0in\"><BR>\n" +
                "</P>";
        textView.append(Html.fromHtml(carreraTecnicoSup));
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: //hago un case por si en un futuro agrego mas opciones
                Log.i("ActionBar", "Atrás!");
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}