package com.exito.test.automation.e2e.models.scena;


import com.exito.test.automation.e2e.models.params.PlantillaParams;
import com.exito.test.automation.e2e.models.params.features.catalogo.PedidoParams;
import com.exito.test.automation.e2e.models.params.features.compra.inicio.InicioCompraParams;
import com.exito.test.automation.e2e.models.params.features.menu.MenuPortalParams;
import lombok.Data;

@Data
public class Libreto {

    private PlantillaParams parametrosPlantilla;

    private MenuPortalParams parametrosMenuPortal;

    private PedidoParams parametrosPedido;

    private InicioCompraParams parametrosInicioCompra;
}

