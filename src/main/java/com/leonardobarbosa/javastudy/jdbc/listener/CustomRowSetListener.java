package com.leonardobarbosa.javastudy.jdbc.listener;

import lombok.extern.log4j.Log4j2;

import javax.sql.RowSet;
import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;
import java.sql.SQLException;

@Log4j2
public class CustomRowSetListener implements RowSetListener {

    // Chamado quando o conteúdo do RowSet é alterado, como após a execução de execute()
    @Override
    public void rowSetChanged(RowSetEvent event) {
        log.info("Comand execute triggered");
    }

    // Chamado quando uma linha do RowSet é inserida, atualizada ou excluída
    @Override
    public void rowChanged(RowSetEvent event) {
        log.info("Row inserted, updated or deleted");

        // Verifica se o objeto que gerou o evento implementa RowSet
        if (event.getSource() instanceof RowSet rowSet) {
            try {
                // Reexecuta o comando SQL para atualizar o conteúdo do RowSet
                rowSet.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Chamado quando o cursor de navegação do RowSet muda de posição
    @Override
    public void cursorMoved(RowSetEvent event) {
        log.info("Cursor moved");
    }
}
