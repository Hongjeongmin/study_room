#!/usr/bin/env python

import os
from urllib import parse

HEADER = """## 알고리즘

---
"""
FOOTER = """
## 커밋 규칙

---

파일명 : 사이트_난이도_문제이름

커밋명 : 날짜 | 이름

해당날짜 해당 폴더에 올려주세용

"""

def main():
    content = ""
    content += HEADER

    directories = []

    for root, dirs, files in os.walk("./algorithm"):
        dirs.sort()
        category = os.path.basename(root)
        directory = os.path.basename(os.path.dirname(root))

        if directory == '.':
            # if len(files) == 1:
            #     content += "## [{}]({})\n".format(category, parse.quote(os.path.join(root, files[0])))
            #     directories.append(category)
            continue

        content += "### [{}]({})\n".format(category, parse.quote(os.path.join(category)))
        for file in files:
            content += "- [{}]({})\n".format(file, parse.quote(os.path.join(category, file)))
        content += "\n"
    content += FOOTER

    with open("./algorithm/check.md", "w") as fd:
        fd.write(content)


if __name__ == "__main__":
    main()
