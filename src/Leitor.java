
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Matheus PC
 */
public class Leitor {

    private byte[] bytes;
    private int index;
    //Coverte o arquivo binário em um vetor de bytes (bytes)
    //Chama métodos que irão converter determinado tipo de dado,
    //a partir do index, e sempre que for lido um byte, o index é incrementado
    //para que a próxima leitura não seja "releitura".
    //Quando index tiver tamanho do vetor, indica fim, e será retornado ArrayList<ClimaDoDia>
    public ArrayList<ClimaDoDia> Converte(Path a) throws IOException, ParseException, Exception {
        bytes = Files.readAllBytes(a);
        index = 0;
        ArrayList<ClimaDoDia> climaDoDia = new ArrayList<ClimaDoDia>();
            while (index < bytes.length) {
            try {
                ClimaDoDia classe = new ClimaDoDia();
                classe.setData(data());
                classe.setVentoDirecao(caracter());
                classe.setVentoVelocidade(inteiro());
                classe.setIndicePluviometrico(inteiro());
                classe.setTemperatura(quebrado());
                climaDoDia.add(classe);
            } catch (Exception e) {
                throw new Exception("");
            }
        }
        return climaDoDia;
    }

    public Date data() throws ParseException {
        byte[] local = new byte[11];
        int j = 0;
        for (int i = index; i < index + 11; i++) {
            local[j] = bytes[i];
            j++;
        }
        String[] a = new String(local).split("/");
        int v1 = converteParaInt(a[0]);
        int v2 = converteParaInt(a[1]);
        int v3 = converteParaInt(a[2]);
        index += 10;
        if(v1 >= 10)
        index ++;
        if(v2 >= 10)
        index ++;
        SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
        Date data = new Date();
        data = sf.parse(v1+"/"+v2+"/"+v3);
        return data;
    }

    public int inteiro() {
        int retorno = 0;
        for (int i = index; i < index + 4; i++) {
            retorno += (int) bytes[i];
        }
        index = index + 4;
        return retorno;
    }

    public double quebrado() throws UnsupportedEncodingException {
        byte[] retorno = new byte[8];
        int j = 0;
        for (int i = index; i < index + 8; i++) {
            retorno[j] = bytes[i];
            j++;
        }
        index = index + 8;
        return ByteBuffer.wrap(retorno).getDouble();
    }

    public String caracter() {
        String retorno = "";
        for (int i = index; i < index + 4; i++) {
            retorno += (char) bytes[i];
        }
        index = index + 4;
        return retorno;
    }

    private int converteParaInt(String input) {
        int retorno = -1;
        try {
            retorno = Integer.parseInt(input.replaceAll("[^0-9]", ""));
        } catch (Exception e) {
        }
        return retorno;
    }
}
