import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
public class Main {

	public static void main(String[] args) throws IOException{
		
		//Vetor para Maratonistas profissionais
				Professional_Marathonist[] MaratonistaPro;
				
				//Vetor para Maratonistas Amadores
				Amateur_Marathonist[] MaratonistaAmador;
				
				//Vetor para Maratonistas Fantasiados
				Costumed_Marathonist[] MaratonistaFantasiado;
				
				//Vetor para Doação
				Donate[] Doacao;
				
		       //Definição dos vetores
			        MaratonistaPro=new Professional_Marathonist[10];
			        MaratonistaAmador=new Amateur_Marathonist[10];
			        MaratonistaFantasiado=new Costumed_Marathonist[10];
			        Doacao=new Donate[10];
		       
		       
		        
		        
		        
		        //Cadastro Inicial de corredores
		         try(BufferedReader read = new BufferedReader(new FileReader("C:\\Users\\Noberto\\Desktop\\Documentos Corrida\\DadosCorredores.txt"))) {
		        
		        String linha;
		        String[]texto=new String[8];
		        linha=read.readLine();
		       
		        
		        int percorrerMaratonistaProfissional=0;
		        int percorrerMaratonistaAmador=0;
		        int percorrerMaratonistaFantasiado=0;
		        //Percorre todo arquivo enquanto linhas do arquivo forem diferentes de nulo salvando na String de cadastro
		        while(linha!=null) {
		        	 texto=linha.split(",");
		        	 //Preenchimento dos vetores
		        	 
				        	
				        	if(texto[1].equals("Profissional")) {
				        		MaratonistaPro[percorrerMaratonistaProfissional]=new Professional_Marathonist(texto[0],texto[1],texto[2],texto[3],texto[4],texto[5],texto[6]);
				        		percorrerMaratonistaProfissional++;
				        		
				        	}
				        	else if(texto[1].equals("Amador")) {
				        		MaratonistaAmador[percorrerMaratonistaAmador]=new Amateur_Marathonist(texto[0],texto[1],texto[2],texto[3],texto[4],texto[5],texto[6]);
				        		percorrerMaratonistaAmador++;
				        		
				        	}
				        	else if(texto[1].equals("Fantasiado")) {
				        		MaratonistaFantasiado[percorrerMaratonistaFantasiado]=new Costumed_Marathonist(texto[0],texto[1],texto[2],texto[3],texto[4],texto[5],texto[6],texto[7]);
				        		percorrerMaratonistaFantasiado++;
				        	}
				        		
		        	 linha=read.readLine();
		        	 
		        }
		        read.close();
		        
		         }
		         catch(Exception e) {
		        	 System.out.println("Não foi possível abrir o arquivo");
		         }
		         
		         
		        /////////////////////////////////////////////////////////////////////////////Pódio////////////////////////////////////////////////////////
		         
		        int k=0;
		        String vencedor = "";
				double primeiroT = 0;
				double segundoT = 0;
				double terceiroT = 0;
				double tempo1 = 1000, tempo2 = 1000, tempo3 = 1000;
				String[]texto= new String[3];
				
				//formatar para retirar o 0 do double
				DecimalFormat format= new DecimalFormat("##");
				
				for (k= 0; MaratonistaPro[k]!=null; k++) {
					
					texto=MaratonistaPro[k].conclusaoProva.split(":");
					
					primeiroT = Double.parseDouble(texto[0]);
					segundoT = Double.parseDouble(texto[1]);
					terceiroT = Double.parseDouble(texto[2]);
					
					//Compara os valores
					
					if (terceiroT < tempo3 && segundoT < tempo2 && primeiroT < tempo1) {
						tempo1 = primeiroT;
						tempo2 = segundoT;
						tempo3 = terceiroT;
						
						//Juntar em uma String só
						String resultadoCorrida = format.format(tempo1) + ":" + format.format(tempo2) + ":"
								+ format.format(tempo3);
						
						//Comparar entre os corredores
						if(resultadoCorrida.equals(MaratonistaPro[k].conclusaoProva)) {
							vencedor=MaratonistaPro[k].nome;
						}
						
						}
					
					
					
				}
				
				//////////////////////////////////////////////////Lista de Doação/////////////////////////////////////////////////
				
				
				int d=0;
				//percorre o vetor
				int percorrerDoadorAmador=0;
				int percorrerDoadorFantasiado=0;
				double total=0;
				//Variaveis para armazenar
				String textoValor;
				double valor=0;
				String nomeDoador;
				
				//Armazenar os valores dos Maratonistas Amadores no Vetor de Doações
				
				for( percorrerDoadorAmador=0;MaratonistaAmador[percorrerDoadorAmador]!=null;percorrerDoadorAmador++) {
					textoValor=MaratonistaAmador[percorrerDoadorAmador].valor;
					nomeDoador=MaratonistaAmador[percorrerDoadorAmador].nome;
					valor=Double.parseDouble(textoValor);
					total=total+valor;
					Doacao[d]=new Donate(valor,nomeDoador);
					d++;
				}
				
				
				
				//Armazenar os valores dos Maratonistas Fantasiados no Vetor de Doações
				
					for(percorrerDoadorFantasiado=0;MaratonistaFantasiado[percorrerDoadorFantasiado]!=null;percorrerDoadorFantasiado++) {
						textoValor=MaratonistaFantasiado[percorrerDoadorFantasiado].valor;
						nomeDoador=MaratonistaFantasiado[percorrerDoadorFantasiado].nome;
						valor=Double.parseDouble(textoValor);
						total=total+valor;
						Doacao[d]=new Donate(valor,nomeDoador);
						d++;
					}
				
				
				///////////////////////////////////////////////////////CRIAR ARQUIVO///////////////////////////////////////////////////////////
				int percorrerMaratonistaPro=0;
				int percorrerMaratonistaAma=0;
				int percorrerMaratonistaFanta=0;
				int percorrerDoacao=0;
				try(BufferedWriter Criar=new BufferedWriter(new FileWriter("C:\\Users\\Noberto\\Desktop\\Documentos Corrida\\Resultados.txt"));) {
					
					//Escrever dados do Maratonista Profissional
					Criar.write("PROFISSIONAL");
					Criar.newLine();
					for(percorrerMaratonistaPro=0;MaratonistaPro[percorrerMaratonistaPro]!=null;percorrerMaratonistaPro++) {
						String linha1="Nome:"+MaratonistaPro[percorrerMaratonistaPro].nome + "Tipo:"+MaratonistaPro[percorrerMaratonistaPro].tipo + "Estado:"+MaratonistaPro[percorrerMaratonistaPro].estado + "País:"+MaratonistaPro[percorrerMaratonistaPro].pais + "Número:"+MaratonistaPro[percorrerMaratonistaPro].numero + "Tempo de conclusão:"+MaratonistaPro[percorrerMaratonistaPro].conclusaoProva + "Ranking:"+MaratonistaPro[percorrerMaratonistaPro].getRanking();
						
						Criar.write(linha1);
						Criar.newLine();
					}
					
						Criar.newLine();
						
						
					//Escrever dados do Maratonista Amador
					Criar.write("AMADOR");
					Criar.newLine();
							for(percorrerMaratonistaAma=0;MaratonistaAmador[percorrerMaratonistaAma]!=null;percorrerMaratonistaAma++) {
								String linha2="Nome:"+MaratonistaAmador[percorrerMaratonistaAma].nome + "Tipo:"+MaratonistaAmador[percorrerMaratonistaAma].tipo + "Estado:"+MaratonistaAmador[percorrerMaratonistaAma].estado + "País:"+MaratonistaAmador[percorrerMaratonistaAma].pais + "Número:"+MaratonistaAmador[percorrerMaratonistaAma].numero + "Tempo de conclusão:"+MaratonistaAmador[percorrerMaratonistaAma].conclusaoProva + "Valor:"+MaratonistaAmador[percorrerMaratonistaAma].valor;
								Criar.write(linha2);
								
								Criar.newLine();
							}
							
								Criar.newLine();
								
								
					//Escrever dados do Maratonista Fantasiado
					Criar.write("FANTASIADO");
					Criar.newLine();
									for(percorrerMaratonistaFanta=0;MaratonistaFantasiado[percorrerMaratonistaFanta]!=null;percorrerMaratonistaFanta++) {
										String linha3="Nome:"+MaratonistaFantasiado[percorrerMaratonistaFanta].nome + "Tipo:"+MaratonistaFantasiado[percorrerMaratonistaFanta].tipo + "Estado:"+MaratonistaFantasiado[percorrerMaratonistaFanta].estado + "País:"+MaratonistaFantasiado[percorrerMaratonistaFanta].pais + "Número:"+MaratonistaFantasiado[percorrerMaratonistaFanta].numero + "Tempo de conclusão:"+MaratonistaFantasiado[percorrerMaratonistaFanta].conclusaoProva + "Ranking:"+MaratonistaFantasiado[percorrerMaratonistaFanta].valor + "Fantasia:"+MaratonistaFantasiado[percorrerMaratonistaFanta].getFantasia();
										Criar.write(linha3);
										
										Criar.newLine();
									}
									
										Criar.newLine();
										
										//Printar vencedor
										Criar.write("Vencedor:"+vencedor);
										Criar.newLine();
										
					//Dados da doação
					Criar.write("DOADORES");
					Criar.newLine();
									for(percorrerDoacao=0;Doacao[percorrerDoacao]!=null;percorrerDoacao++) {
										String linha4="Nome:"+Doacao[percorrerDoacao].getNome() + "Valor doado:"+Doacao[percorrerDoacao].getValor();
										Criar.write(linha4);
										Criar.newLine();
									}
								
								Criar.newLine();
						
					//Valor total Doado
								Criar.write("Valor total arrecadado:"+total);
								
								Criar.close();
				}
				catch(Exception e) {
					System.out.println();
					
				}
				
				
				
				
				
				
				
		       
		        
		        	
				 
        
	
	
}
}
