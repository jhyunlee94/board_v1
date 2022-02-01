package board.board.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import board.board.dto.BoardDto;
import board.board.mapper.BoardMapper;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper boardMapper;

    @Override
    public List<BoardDto> selectBoardList() throws Exception {
        return boardMapper.selectBoardList();
    }

	@Override
	public void insertBoard(BoardDto board,MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
		// TODO Auto-generated method stub
		//boardMapper.insertBoard(board); //업로드된 파일의 정보를 확인하는 목적이므로 게시글이 저장되지않도록 주석처리
		
		
		if(ObjectUtils.isEmpty(multipartHttpServletRequest)==false) {
			Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
			// boardWrite.html에서 파일 첨부 시 사용하는 파일 태그를 생각해보면, files라는 이름(name)으로 서버에 전송되고 하나의 파일 태그로 여러 파일을 전송 할 수 있습니다.
			// 하지만, 화면 구성에 따라 파일 태그가 여러 개 있을 수도 있고, 화면에서 사용되는 파일 태그의 이름을 알 수 없을 수도 있습니다.
			//또한, 파일 태그의 이름을 아더라도 해당 이름을 코드에 직접 사용하면 추후 파일 태그명이 변경되면 기존에 작성한 코드를 변경해야 하는 불편함ㅁ이 있습니다.
			//이런 문제를 해결하기 위해 MultipartHttpServletRequest는 getFileNames라는 메소드를 제공합니다.
			//이 메소드를 사용하면, 서버로 한번에 전송되는 한 개 이상의 파일 태그 이름을 iterator형식으로 가져 올 수 있슨니다. 
			String name;
			while(iterator.hasNext()) {
				name = iterator.next();
				log.debug("file tag name : " + name);
				List<MultipartFile> list = multipartHttpServletRequest.getFiles(name);
				//앞서 가져온 파일 태그 이름을 이용해 파일 태그에서 선택된 파일을 가져옵니다
				//파일 태그는 multiple 속성을 설정함으로써 여러 개의 파일이 첨부 될 수 있어 list형태로 파일 목록을 받아왔습니다.
				for(MultipartFile multipartFile : list) { // 받아온 파일 정보를 표시합니다. 업로드된 파일은 MultipartFile 인터페이스로 표현됩니다.
					log.debug("start file information");
					log.debug("file name" + multipartFile.getOriginalFilename());
					log.debug("file size : " + multipartFile.getSize());
					log.debug("file content type : " + multipartFile.getContentType());
					log.debug("endd file information.\n");
				}
			}
		}
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