package com.zoomtecnologia.zox.servico.impl;

import com.zoomtecnologia.zox.modelo.estoque.Ncm;
import com.zoomtecnologia.zox.servico.NcmService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("ncmService")
@Transactional
public class NcmServiceImpl extends GenericServiceImpl<Ncm> implements NcmService {

}
