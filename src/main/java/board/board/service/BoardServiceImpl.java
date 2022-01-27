package board.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import board.board.dto.BoardDto;
import board.board.mapper.BoardMapper;

@Service
@Transactional
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper boardMapper;

    @Override
    public List<BoardDto> selectBoardList() throws Exception {
        return boardMapper.selectBoardList();
    }

	@Override
	public void insertBoard(BoardDto board) throws Exception {
		// TODO Auto-generated method stub
		boardMapper.insertBoard(board);
	}

	@Override
	public BoardDto selectBoardDetail(int boardIdx) throws Exception {
		boardMapper.updateHitCount(boardIdx);
//		int i = 10 / 0;
		BoardDto board = boardMapper.selectBoardDetail(boardIdx);
		return board;
	}

	@Override
	public void updateBoard(BoardDto board) throws Exception {
		// TODO Auto-generated method stub
		boardMapper.updateBoard(board);
		
	}

	@Override
	public void deleteBoard(int boardIdx) throws Exception {
		// TODO Auto-generated method stub
		boardMapper.deleteBoard(boardIdx);
		
	}

}