import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class ProcessamentoDePagamentos {
    // Logger SLF4j
    private static final Logger logger = LoggerFactory.getLogger(ProcessamentoDePagamentos.class);

    public static void main(String[] args) {
        // implemente o codigo necessario para resolucao do problema
        Random random = new Random();
        final int totalPagamentos = 5;

        for (int i = 1; i <= totalPagamentos; i++) {
            logger.info("Iniciando o processamento do pagamento {}", i);

            int estado = random.nextInt(3);

            try {
                Thread.sleep(1000); // simula o tempo de processamento
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                logger.error("Thread interrompida durante o processamento do pagamento {}", i);
            }

            switch (estado) {
                case 0:
                    logger.info("Pagamento {} processado com sucesso.", i);
                    break;
                case 1:
                    logger.error("Erro ao processar o pagamento {}: Falha na transação.", i);
                    break;
                case 2:
                    logger.warn("Pagamento {} está pendente. Aguardando confirmação.", i);
                    break;
            }
        }
        logger.info("Processamento de pagamentos concluído.");
    }
}