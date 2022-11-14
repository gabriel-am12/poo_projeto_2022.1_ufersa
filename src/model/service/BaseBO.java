package model.service;

import java.util.List;

public class BaseBO<VO> implements BaseInterBO<VO> {
	public void cadastrar(VO vo) throws Exception{
		
	}
	public VO buscarPorId(VO vo) throws Exception{
		return vo;
	}
	public List<VO> listar() throws Exception{
		return null;
	}
	public boolean alterar(VO vo) throws Exception{
		return true;
	}
	public void remover(VO vo) throws Exception{
		
	}
	@Override
	public boolean adicionar(VO vo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean atualizar(VO vo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean apagar(VO vo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
}