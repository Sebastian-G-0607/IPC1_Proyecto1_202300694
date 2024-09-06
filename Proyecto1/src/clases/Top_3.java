package clases;

import java.util.List;

/**

 @author sebas
 */
public class Top_3 {
    
    private String codigo1, codigo2, codigo3, nombre1, nombre2, nombre3;
    private int num1, num2, num3;
    
    
    public void obtener_top3(List<Investigador> investigadores){
        
        int[] num_experimentos = new int[investigadores.size()];
       
        for(int i=0; i<num_experimentos.length; i++){
            num_experimentos[i] = investigadores.get(i).getNumExperimentos();
        }
        
        int max = -1, index1 = 0, index2 = 0, index3 = 0;

        
        for(int i=0; i<num_experimentos.length; i++){
            if(num_experimentos[i] > max){
                max = num_experimentos[i];
                index1 = i;
            }
        }
        
        int[] copia1 = new int[num_experimentos.length];
        
        for(int i=0; i<copia1.length; i++){
            if(i != index1){
                copia1[i] = num_experimentos[i];
            }
            else{
                copia1[i] = -1;
            }
        }
       
        max = -1;
        
        for(int i=0; i<copia1.length; i++){
            if(copia1[i] > max){
                max = copia1[i];
                index2 = i;
            }
        }
        
        for(int i=0; i<copia1.length; i++){
            if(i != index1 && i != index2){
                copia1[i] = num_experimentos[i];
            }
            else{
                copia1[i] = -1;
            }
        }
        
        max = -1;
        
        for(int i=0; i<copia1.length; i++){
            if(copia1[i] > max){
                max = copia1[i];
                index3 = i;
            }
        }
        
        codigo1 = investigadores.get(index1).getCodigo();
        codigo2 = investigadores.get(index2).getCodigo();
        codigo3 = investigadores.get(index3).getCodigo();
        
    }
    
    public void nombres_experimentos(List<Investigador> investigador, String codigo1, String codigo2, String codigo3){

        for(Investigador investigador_temp:investigador){
            if(investigador_temp.getCodigo().equals(codigo1)){
                nombre1 = investigador_temp.getNombre();
                num1 = investigador_temp.getNumExperimentos();
            }
            else if(investigador_temp.getCodigo().equals(codigo2)){
                nombre2 = investigador_temp.getNombre();
                num2 = investigador_temp.getNumExperimentos();
            }
            else if(investigador_temp.getCodigo().equals(codigo3)){
                nombre3 = investigador_temp.getNombre();
                num3 = investigador_temp.getNumExperimentos();
            }
        }        
    }

    public String getCodigo1() {
        return codigo1;
    }

    public String getCodigo2() {
        return codigo2;
    }

    public String getCodigo3() {
        return codigo3;
    }

    public String getNombre1() {
        return nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public String getNombre3() {
        return nombre3;
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }

    public int getNum3() {
        return num3;
    }
    
    
    
}
