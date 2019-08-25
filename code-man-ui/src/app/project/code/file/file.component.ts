import {Component, OnInit} from '@angular/core';
import {CodeService} from '../../../service/code.service';
import {CodeFileModel, FileTypeEnum} from '../../../model/code.model';
import {ActivatedRoute} from '@angular/router';
import {FlatTreeControl} from '@angular/cdk/tree';
import {MatTreeFlatDataSource, MatTreeFlattener} from '@angular/material';


@Component({
  selector: 'app-code',
  templateUrl: './file.component.html',
  styleUrls: ['./file.component.css']
})
export class FileComponent implements OnInit {

  constructor(private codeService: CodeService,
              private activeRoute: ActivatedRoute) {
  }

  // project
  projectId: string;
  codeId: string;
  // tree
  file: CodeFileModel;
  treeControl = new FlatTreeControl<CodeFileModel>(
    node => node.level, node => node.type === FileTypeEnum.DIR && node.children.length > 0);
  treeFlattener = new MatTreeFlattener(
    (node: CodeFileModel, level: number) => {
      return {
        expandable: !!node.children && node.children.length > 0,
        name: node.name,
        level,
      };
    },
    node => node.level, node => node.expandable, node => node.children);
  dataSource = new MatTreeFlatDataSource(this.treeControl, this.treeFlattener);
  // branch
  branches: string[];
  currentBranch: string;
  hasChild = (_: number, node: ExampleFlatNode) => node.expandable;

  ngOnInit(): void {
    this.activeRoute.parent.parent.paramMap.subscribe(params => {
      this.activeRoute.paramMap.subscribe(subParams => {
        this.projectId = params.get('projectId');
        this.codeId = subParams.get('codeId');
        this.initBranchesAndFiles();
      });
    });
  }

  initBranchesAndFiles() {
    this.codeService.queryCodeBranches(this.projectId, this.codeId).subscribe(branches => {
      this.branches = branches;
      this.currentBranch = branches[0];
      this.changeBranch();
    });
  }

  private initFiles(branch: string) {
    this.codeService.queryCodeFileTree(this.projectId, this.codeId, branch).subscribe(codeFile => {
      this.file = codeFile;
      this.dataSource.data = [this.file];
    });
  }

  changeBranch() {
    this.initFiles(this.currentBranch);
  }
}

interface ExampleFlatNode {
  expandable: boolean;
  name: string;
  level: number;
}

