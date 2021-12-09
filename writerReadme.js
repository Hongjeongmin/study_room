const fs = require('fs');

/*
** 무시하고 싶은 폴더의 이름을 확장자명 까지 써주세요 :)
*/
const ignores = ['README.md','image','node_modules','writerReadme.js','package-lock.json','package.json','.git','.gitignore'];
const baseTagCount = 2;
let text;

const idDir = (stream) => {
    return fs.lstatSync(stream).isDirectory();
};

const createTage = (count, tag) => {
    return Array(count).fill(tag).join('');
};

const searchDirectory = (__dirname, deeps) => {

    let filelist = fs.readdirSync(__dirname);

    filelist = filelist.filter((name) => {
        return ignores.every((ignore) => ignore !== name);
    });

    // TODO : 정렬을 해야합니다. 파일을 앞쪽으로 디렉토리를 뒤쪽으로~
    // idDir를 이용해서 변경해주세요 ㅎㅎ..

    filelist.forEach((name) => {
        if(!idDir(`${__dirname}/${name}`)) {
            text += `[${createTage(deeps, ' ')}- ${name}](${__dirname}/${name})\n`;

        }else {
            text += `${createTage(deeps + baseTagCount,'#')} ${name}\n`;
            searchDirectory(`${__dirname}/${name}`, deeps + 1);
        }
    });

}

const init = () => {
    text = '# 우리의 스터디 공부일지\n';
};

const writeFile = () => {
    text +=
`
# 저장공간 README.md 업데이트 방법.
- node 16 LTS 버전을 다운한다.
- npm install 한다.
- npm start 를 실행한다.
- 이상 즐겁게 공부하다 :)
`;
    fs.unlinkSync('README.md');
    fs.writeFileSync('README.md', text);
}

const main = () => {
    init();
    searchDirectory('./', 0);
    writeFile();
};

main();